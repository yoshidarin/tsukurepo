package com.example.tsukurepo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.CreateReportData
import com.example.tsukurepo.data.HeaderData
import com.example.tsukurepo.data.ReportData
import com.example.tsukurepo.data.WorkItemData
import com.example.tsukurepo.data.entities.toDateStr
import com.example.tsukurepo.data.entities.toStartTimeStr

class CreateReportAdapter(
    val list: List<CreateReportData>
) : RecyclerView.Adapter<CreateReportAdapter.ParentViewHolder>() {

    enum class ListStyle(val type: Int){
        HeaderType(0),
        NormalType(1)
    }
    open class ParentViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView)

    class HeaderHolder(itemView: View):ParentViewHolder(itemView) {
        val titleText = itemView.findViewById<TextView>(R.id.work_item_header)
    }

    class CreateReportHolder(itemView: View):ParentViewHolder(itemView) {
        val workDateText = itemView.findViewById<TextView>(R.id.work_date)
        val workStartTime = itemView.findViewById<TextView>(R.id.work_start_time)
        val workEndtTime = itemView.findViewById<TextView>(R.id.work_end_time)
    }

    interface ListListener {
        fun onClickItem(tappedView: View, workItemData: WorkItemData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder =
        when(viewType){
            // HeaderType
            ListStyle.HeaderType.type -> {
                val view =  LayoutInflater.from(parent.context).inflate(R.layout.work_item_header_view, parent,false)
                HeaderHolder(view)
            }
            // NormalType
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.work_item_view, parent, false)
                CreateReportHolder(view)

            }
        }



    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val data = list[position]
        when {
            holder is HeaderHolder && data is HeaderData -> {
                holder.titleText.text = data.title
            }
            holder is CreateReportHolder && data is WorkItemData -> {
                holder.workDateText.text = data.workDate.toDateStr()
                holder.workStartTime.text = data.startTime.toStartTimeStr()
                holder.workEndtTime.text = data.endTime.toStartTimeStr()
            }
        }
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