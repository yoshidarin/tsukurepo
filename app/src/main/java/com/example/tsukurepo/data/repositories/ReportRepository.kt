package com.example.tsukurepo.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.tsukurepo.data.ReportData
import com.example.tsukurepo.data.ReportDatabase
import com.example.tsukurepo.data.dao.ReportDao
import com.example.tsukurepo.data.entities.ReportEntity
import javax.inject.Inject


class ReportRepository @Inject constructor(
    private val reportDao: ReportDao
) {

    //report一覧を取得する
    suspend fun loadLiveData(): LiveData<List<ReportData>> {
        return reportDao.loadLiveData().switchMap { listEntity ->
            val a = listEntity.map { entity ->
                ReportData(
                    id = entity.id,
                    startDate = entity.startDate,
                    workDetails = entity.workDetails,
                    impression = entity.impressions,
                )
            }
            MutableLiveData(a)
        }
    }

    // reportをidで取得する
    suspend fun getLiveDataReport(id: Int): LiveData<ReportData> {
        return reportDao.getLiveDataReport(id).switchMap { entity ->
            MutableLiveData(
                ReportData(
                    id = entity.id,
                    startDate = entity.startDate,
                    workDetails = entity.workDetails,
                    impression = entity.impressions,
                )
            )
        }
    }
    // upsert reportを保存する
    suspend fun upsertData(report: ReportEntity){
        return reportDao.upsert(report)
    }


}