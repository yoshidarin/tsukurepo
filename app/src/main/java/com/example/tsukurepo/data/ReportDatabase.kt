package com.example.tsukurepo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tsukurepo.data.dao.ReportDao
import com.example.tsukurepo.data.dao.WorkItemDao
import com.example.tsukurepo.data.entities.ReportEntity
import com.example.tsukurepo.data.entities.WorkItemEntity

@Database(entities = [ReportEntity::class, WorkItemEntity::class], version = 1, exportSchema = false) // 使用するEntityを指定
@TypeConverters(DateConverter::class)
abstract class ReportDatabase : RoomDatabase() {
    // 使用するDaoを指定
    abstract fun reportDao(): ReportDao
    abstract fun workItemDao(): WorkItemDao

    // データベースのビルド
    // 書く場所はここじゃなくてもいい
    companion object {
        fun buildDatabase(context: Context): ReportDatabase {
            return Room.databaseBuilder(
                context,
                ReportDatabase::class.java, "report-database"
            ).build()
        }
    }

}