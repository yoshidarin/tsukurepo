package com.example.tsukurepo.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.tsukurepo.data.entities.ReportEntity

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