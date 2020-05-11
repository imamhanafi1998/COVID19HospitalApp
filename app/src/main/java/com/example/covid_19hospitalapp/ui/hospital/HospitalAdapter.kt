package com.example.covid_19hospitalapp.ui.hospital

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19hospitalapp.R
import kotlinx.android.synthetic.main.hospital_list_item.view.*

class HospitalAdapter (val hospitalItemList: List<HospitalData>, val clickListener: (HospitalData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.hospital_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(hospitalItemList[position], clickListener)
    }

    override fun getItemCount() = hospitalItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hospital: HospitalData, clickListener: (HospitalData) -> Unit) {
            itemView.hospitalName.text = hospital.hospitalName.toString()
            itemView.setOnClickListener { clickListener(hospital) }
        }
    }
}