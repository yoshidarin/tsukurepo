package com.example.tsukurepo.Data.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tsukurepo.Data.ReportDatabase
import com.example.tsukurepo.Data.dao.ReportDao
import com.example.tsukurepo.Data.entities.ReportEntity
import com.example.tsukurepo.Data.repositories.ReportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val reportRepository: ReportRepository
) : ViewModel() {



    // DBにデータを保存
    fun insert() {
        viewModelScope.launch(Dispatchers.IO) {
            reportRepository.upsertData(
                ReportEntity(
                    id = 0, // autoGenerate で自動的にIDを入れるときは0を入れる
                    startDate = Date(),
                    workDetails = "通常勤務",
                    impressions = "aiueo"
                )
            )
        }
    }


}