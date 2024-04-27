package com.example.tsukurepo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tsukurepo.data.dao.ReportDao
import com.example.tsukurepo.data.entities.ReportEntity

@Database(entities = [ReportEntity::class], version = 1, exportSchema = false) // 使用するEntityを指定
abstract class ReportDatabase : RoomDatabase() {
    // 使用するDaoを指定
    abstract fun reportDao(): ReportDao

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