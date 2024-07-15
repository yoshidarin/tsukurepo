package com.example.tsukurepo.data.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ReportData

class CurrentWeekAdapter(
    private val list: List<ReportData>,
    private val listener: ListListener
): RecyclerView.Adapter<CurrentWeekAdapter.CurrentWeekViewHolder>() {

    class CurrentWeekViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemDateText: TextView = itemView.findViewById(R.id.item_date)
        val itemDayText: TextView= itemView.findViewById(R.id.item_date_day)
        val itemEditDayText: TextView= itemView.findViewById(R.id.item_edit_date)
    }
    interface ListListener {
        fun onClickItem(tappedView: View, reportData: ReportData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentWeekViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.week_item_view, parent, false)
        return CurrentWeekViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrentWeekViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_date).text = list[position].startDate
        holder.itemView.findViewById<TextView>(R.id.item_title).text = list[position].workDetails
        holder.itemView.findViewById<TextView>(R.id.item_edit_date).text = list[position].impression
        holder.itemView.setOnClickListener {
            listener.onClickItem(it, list[position])
        }
    }

    override fun getItemCount(): Int = list.size

}