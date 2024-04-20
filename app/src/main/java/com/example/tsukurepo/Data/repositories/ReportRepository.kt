package com.example.tsukurepo.Data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.tsukurepo.Data.ReportDatabase
import com.example.tsukurepo.Data.dao.ReportDao
import com.example.tsukurepo.Data.entities.ReportEntity
import javax.inject.Inject


class ReportRepository @Inject constructor(context: Context) {
    @Inject
    private val reportDao: ReportDao
    init {
        val db = ReportDatabase.buildDatabase(context) // DBにアクセスするclassで一度だけDBをビルドする
        reportDao = db.reportDao() // 使用するDaoを指定
    }
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