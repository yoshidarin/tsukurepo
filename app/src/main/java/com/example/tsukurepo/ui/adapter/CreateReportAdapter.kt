package com.example.tsukurepo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.CreateReportData
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
    open class ParentViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    class HeaderHolder(itemView: View):ParentViewHolder(itemView){
        val titleTextView = itemView.findViewById<TextView>(R.id.work_item_header).text
    }

    class CreateReportHolder(itemView: View):ParentViewHolder(itemView){
        val workDateText = itemView.findViewById<TextView>(R.id.work_date).text
        val workStartTime = itemView.findViewById<TextView>(R.id.work_start_time).text
        val workEndtTime = itemView.findViewById<TextView>(R.id.work_end_time).text
    }


    interface ListListener {
        fun onClickItem(tappedView: View, workItemData: WorkItemData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateReportHolder {

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
                return CreateReportHolder(view)
            }
        }

    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val data = list[position]
        // holderもdataもHeaderの場合
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