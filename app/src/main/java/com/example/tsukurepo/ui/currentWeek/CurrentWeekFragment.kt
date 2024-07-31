package com.example.tsukurepo.ui.currentWeek

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ReportData
import com.example.tsukurepo.ui.adapter.CurrentWeekAdapter
import com.example.tsukurepo.ui.calender.CalenderFragment
import com.example.tsukurepo.ui.main.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar

class CurrentWeekFragment : Fragment(){

    private var currentWeekView: RecyclerView? = null
    private var mainActivity: MainActivity? = null

    companion object {
        fun newInstance() = CurrentWeekFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mainActivity = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_current_week, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.currentWeekView = view.findViewById<RecyclerView>(R.id.fragment_current_week_view)
        this.currentWeekView?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            adapter = CurrentWeekAdapter(
                generateItemList(),
                object : CurrentWeekAdapter.ListListener {
                    override fun onClickItem(tappedView: View, reportData: ReportData) {
                        this@CurrentWeekFragment.onClickItem(tappedView, reportData)
                    }
                }
            )
        }
        val ediBtn = view.findViewById<FloatingActionButton>(R.id.edit_button)
        ediBtn.setOnClickListener{
            mainActivity?.moveToCreateReportFragment()

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.currentWeekView?.adapter = null
        this.currentWeekView = null
    }

    //RecyclerViewの生成時に一度だけ動く
    private fun generateItemList(): List<ReportData> {
        val itemList = mutableListOf<ReportData>()
        val calendar = Calendar.getInstance()
        calendar.set(2024,4,1)
        val instant = calendar.time.toInstant()
        for(i in 1..7){
            itemList.add(
                ReportData(
                    id = i, startDate = instant, workDetails = "週報",
                    impression = "2024/04/03 19:00"
                )
            )
        }
        return itemList
    }

    //RecyclerView内のアイテムがクリックされたときに動く
    private fun onClickItem(tappedView: View, reportData: ReportData) {
    }

}