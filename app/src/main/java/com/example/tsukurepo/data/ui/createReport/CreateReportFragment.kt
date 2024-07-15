package com.example.tsukurepo.data.ui.createReport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ReportData
import com.example.tsukurepo.data.ui.adapter.CreateReportAdapter
import com.example.tsukurepo.data.ui.adapter.CurrentWeekAdapter
import com.example.tsukurepo.data.ui.main.MainViewModel

class CreateReportFragment : Fragment(){

    private var createReportView: RecyclerView? = null
    companion object {
        fun newInstance(viewModel: MainViewModel) = CreateReportFragment()
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




    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.createReportView?.adapter = null
        this.createReportView = null
    }

    //RecyclerViewの生成時に一度だけ動く
    private fun generateItemList(): List<ReportData> {
        val itemList = mutableListOf<ReportData>()

        itemList.add(ReportData(
                    id = 1, startDate = "04月01日(日)", workDetails = "お問い合わせ対応",
                    impression = "今週もよろしくお願いいたします"
                )
            )
        return itemList
    }

    //RecyclerView内のアイテムがクリックされたときに動く
    private fun onClickItem(tappedView: View, reportData: ReportData) {
    }
}