package com.example.tsukurepo.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.tsukurepo.data.ReportDatabase
import com.example.tsukurepo.data.dao.ReportDao
import com.example.tsukurepo.data.entities.ReportEntity
import javax.inject.Inject


class ReportRepository @Inject constructor(
    private val reportDao: ReportDao
) {

    //report一覧を取得する
    suspend fun loadLiveData(): LiveData<List<ReportEntity>>{
        return reportDao.loadLiveData()
    }

    // reportをidで取得する
    suspend fun getLiveDataReport(id: Int): LiveData<ReportEntity> {
        return reportDao.getLiveDataReport(id)
    }
    // upsert reportを保存する
    suspend fun upsertData(report: ReportEntity){
        return reportDao.upsert(report)
    }


}