package com.example.tsukurepo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ReportData
import com.example.tsukurepo.data.WorkItemData
import com.example.tsukurepo.data.entities.toDateStr
import com.example.tsukurepo.data.entities.toStartTimeStr


class CreateReportAdapter(
    val list: List<WorkItemData>


) : RecyclerView.Adapter<CreateReportAdapter.CreateReportHolder>() {

    enum class ListStyle(val type: Int){
        HeaderType(0),
        NormalType(1)
    }
    class CreateReportHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    interface ListListener {
        fun onClickItem(tappedView: View, workItemData: WorkItemData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateReportHolder {
        // TODO: レイアウトをtypeで分ける
        return when(viewType){
            // HeaderType
            ListStyle.HeaderType.type -> {
                val view =  LayoutInflater.from(parent.context).inflate(R.layout.work_item_header_view, parent,false)
                return CreateReportHolder(view)
            }
            // NormalType
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.work_item_view, parent, false)
                return CreateReportHolder(view)
            }
        }

    }

    override fun onBindViewHolder(holder: CreateReportHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.work_date).text = list[position].workDate.toDateStr()
        holder.itemView.findViewById<TextView>(R.id.work_start_time).text = list[position].startTime.toStartTimeStr()
        holder.itemView.findViewById<TextView>(R.id.work_end_time).text = list[position].endTime.toStartTimeStr()
    }
    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        return if(item.isHeader){
            ListStyle.HeaderType.type
        }else{
            ListStyle.NormalType.type
        }
    }

}