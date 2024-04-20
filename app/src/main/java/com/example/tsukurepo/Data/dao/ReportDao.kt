package com.example.tsukurepo.Data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.tsukurepo.Data.entities.ReportEntity

@Dao
interface ReportDao {
    @Upsert
    fun upsert(report: ReportEntity)

    @Query("SELECT * FROM report_table")
    fun loadLiveData(): LiveData<List<ReportEntity>>

    @Query("SELECT * FROM report_table WHERE id = :id")
    fun getLiveDataReport(id: Int): LiveData<ReportEntity>

    @Query("DELETE FROM report_table")
    fun deleteAll()
}