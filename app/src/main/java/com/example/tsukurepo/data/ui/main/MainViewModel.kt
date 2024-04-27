package com.example.tsukurepo.data.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tsukurepo.data.entities.ReportEntity
import com.example.tsukurepo.data.repositories.ReportRepository
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
                    startDate = Date().time.toString(),
                    workDetails = "通常勤務",
                    impressions = "aiueo"
                )
            )
        }
    }


}