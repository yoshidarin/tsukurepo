package com.example.tsukurepo.data.ui.calender

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ui.main.MainFragment
import com.example.tsukurepo.data.ui.main.MainViewModel

class CalenderFragment : Fragment() {

    companion object {
        fun newInstance() = CalenderFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_calender, container, false)
    }
}