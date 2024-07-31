package com.example.tsukurepo.data

import java.time.Instant

data class ReportData(
    val id: Int,
    val startDate: Instant,
    val workDetails: String,
    val impression: String
)
