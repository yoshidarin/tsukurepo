package com.example.tsukurepo.data.ui.currentWeek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ui.calender.CalenderFragment

class CurrentWeekFragment : Fragment(){
    companion object {
        fun newInstance() = CurrentWeekFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_current_week, container, false)
    }
}