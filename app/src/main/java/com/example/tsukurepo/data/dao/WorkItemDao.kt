package com.example.tsukurepo.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.tsukurepo.data.entities.WorkItemEntity
import java.time.Instant

@Dao
interface WorkItemDao {
    @Upsert
    fun upsert(workItem: WorkItemEntity)

    @Query("SELECT * FROM work_item_table")
    fun loadWorkItemData(): LiveData<List<WorkItemEntity>>

    @Query("SELECT * FROM work_item_table WHERE work_date BETWEEN :startDateTime AND :endDateTime")
    fun loadWorkItemDataBetween(startDateTime: Instant, endDateTime: Instant):LiveData<List<WorkItemEntity>>

    @Query("DELETE FROM work_item_table")
    fun deleteAll()

}