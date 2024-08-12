package com.example.tsukurepo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.tsukurepo.R
import com.example.tsukurepo.data.FooterData

class CreateReportFooterAdapter(
    val footerData: FooterData,
) : RecyclerView.Adapter<CreateReportFooterAdapter.FooterViewHolder>(){
    class FooterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val workDetailText = itemView.findViewById<EditText>(R.id.work_details_text)
        val impressionText = itemView.findViewById<EditText>(R.id.impression_text)
    }
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): FooterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.footer_view, parent, false)
        return FooterViewHolder(view)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: FooterViewHolder, position: Int){
        holder.workDetailText.setText(footerData.workDetail)
        holder.impressionText.setText(footerData.impressions)
    }
}