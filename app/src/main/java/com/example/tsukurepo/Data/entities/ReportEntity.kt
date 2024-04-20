package com.example.tsukurepo.Data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "report_table")
data class ReportEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "work_details") val workDetails: String,
    @ColumnInfo(name = "impressions") val impressions: String
)
