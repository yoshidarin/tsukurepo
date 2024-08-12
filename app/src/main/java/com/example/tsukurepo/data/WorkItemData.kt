package com.example.tsukurepo.data

import java.time.Instant

data class WorkItemData(
    val id: Int,
    val workDate: Instant,
    val startTime: Instant,
    val endTime: Instant,
    val comment: String,
    val isHoliday: Boolean,
) : CreateReportData()

data class HeaderData(
    val title: String,
) : CreateReportData(isHeader = true)
