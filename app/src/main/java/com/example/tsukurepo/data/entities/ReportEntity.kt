package com.example.tsukurepo.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant


@Entity(tableName = "report_table")
data class ReportEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "start_date") val startDate: Instant,
    @ColumnInfo(name = "work_details") val workDetails: String,
    @ColumnInfo(name = "impressions") val impressions: String
)
