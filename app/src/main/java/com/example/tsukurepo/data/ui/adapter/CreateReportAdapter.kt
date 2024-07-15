package com.example.tsukurepo.data.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.ReportData

class CreateReportAdapter(

) : RecyclerView.Adapter<CreateReportAdapter.CreateReportHolder>() {

        class CreateReportHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {
            val workDetailsText: TextView = itemView.findViewById(R.id.work_details_text)
            val impressionText: TextView = itemView.findViewById(R.id.impression_text)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateReportHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CreateReportHolder, position: Int) {
        TODO("Not yet implemented")
    }


}