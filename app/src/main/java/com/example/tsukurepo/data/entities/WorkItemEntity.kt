package com.example.tsukurepo.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@Entity(tableName = "work_item_table")
data class WorkItemEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    // 日付
    @ColumnInfo(name = "work_date")
    val workDate: Instant,
    // 開始時間
    @ColumnInfo(name = "start_time")
    val startTime : Instant,
    // 終了時間
    @ColumnInfo(name = "end_time")
    val endTime : Instant,
    // コメント
    @ColumnInfo(name = "comment")
    val comment : String,

    // 休日フラグ
    @ColumnInfo(name = "holiday_flag")
    val isHoliday: Boolean
)
fun Instant.toStartTimeStr() =
    DateTimeFormatter.ofPattern("hh:mm").withZone(ZoneId.systemDefault()).format(this)

fun Instant.toDateStr() =
    DateTimeFormatter.ofPattern("MM月dd日").withZone(ZoneId.systemDefault()).format(this)
