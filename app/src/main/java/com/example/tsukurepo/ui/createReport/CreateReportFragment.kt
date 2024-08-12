package com.example.tsukurepo.ui.createReport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.CreateReportData
import com.example.tsukurepo.data.HeaderData
import com.example.tsukurepo.data.ReportData
import com.example.tsukurepo.data.WorkItemData
import com.example.tsukurepo.ui.adapter.CreateReportAdapter
import java.util.Calendar

class CreateReportFragment : Fragment(){

    private lateinit var createReportRecyclerView: RecyclerView
    private lateinit var workDetailsEditText: EditText
    private lateinit var impressionEditText: EditText

    companion object {
        fun newInstance() = CreateReportFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_create_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createReportRecyclerView = view.findViewById(R.id.create_report_recycler_view)
        workDetailsEditText = view.findViewById(R.id.work_details_text)
        impressionEditText = view.findViewById(R.id.impression_text)


        // RecyclerViewの設定
        createReportRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = CreateReportLayoutManager(requireContext())
            adapter = CreateReportAdapter(generateItemList())
        }
    }
    //RecyclerViewの生成時に一度だけ動く
    private fun generateItemList(): List<CreateReportData> {
        val itemList = mutableListOf<CreateReportData>()
        for (k in 1..2) {
            itemList.add(HeaderData(title = "タイトル$k"))
            for (i in 1..7) {
                val data = WorkItemData(
                    id = i,
                    workDate = Calendar.getInstance().time.toInstant(),
                    startTime = Calendar.getInstance().time.toInstant(),
                    endTime = Calendar.getInstance().time.toInstant(),
                    comment = "通常勤務",
                    isHoliday = false
                )
                itemList.add(data)
            }
        }
        return itemList
    }

    //RecyclerView内のアイテムがクリックされたときに動く
    private fun onClickItem(tappedView: View, reportData: ReportData) {
    }
}