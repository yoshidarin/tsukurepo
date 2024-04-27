package com.example.tsukurepo.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "report_table")
data class ReportEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "start_date") val startDate: String, // Dateにする
    @ColumnInfo(name = "work_details") val workDetails: String,
    @ColumnInfo(name = "impressions") val impressions: String
)
