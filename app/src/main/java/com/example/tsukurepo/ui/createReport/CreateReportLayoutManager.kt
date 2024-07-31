package com.example.tsukurepo.ui.createReport

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class CreateReportLayoutManager(context: Context):LinearLayoutManager(context) {
    private val isScrollEnabled = false
    override fun canScrollVertically(): Boolean {
        return isScrollEnabled && super.canScrollVertically()
    }
}