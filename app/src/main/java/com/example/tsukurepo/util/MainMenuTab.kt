package com.example.tsukurepo.util

import com.example.tsukurepo.R

enum class MainMenuTab(
    val index: Int,
    val tabTitleId: Int
) {
    CURRENT_WEEK(0, R.string.recently),
    CALENDER(1, R.string.calendar)
}
