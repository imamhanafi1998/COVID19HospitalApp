package com.example.covid_19hospitalapp.ui.hospital

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid_19hospitalapp.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HospitalFragment : Fragment() {

    private lateinit var hospitalViewModel: HospitalViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        hospitalViewModel =
            ViewModelProviders.of(this).get(HospitalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_hospital, container, false)
//        val textView: TextView = root.findViewById(R.id.text_hospital)
//        hospitalViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        val testData = createHospitalData()
        root.findViewById<RecyclerView>(R.id.hospitalListRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.hospitalListRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.hospitalListRV).adapter = HospitalAdapter(testData, {hospitalItem: HospitalData -> hospitalItemClicked(hospitalItem)})
        return root
    }

    private fun hospitalItemClicked(hospitalData: HospitalData) {
        val showDetailActivity = Intent(context, HospitalDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, hospitalData.hospitalName.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, hospitalData.hospitalAddress.toString())
        showDetailActivity.putExtra(Intent.EXTRA_PACKAGE_NAME, hospitalData.hospitalContact.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, hospitalData.hospitalWeb.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, hospitalData.hospitalMap.toString())
        startActivity(showDetailActivity)
    }

    private fun createHospitalData() : List<HospitalData> {
        val partList = ArrayList<HospitalData>()
        partList.add(HospitalData("RS Dr. Soetomo 1", "Kota Surabaya 1", "03131310001", "www.example1.com", "123-321"))
        partList.add(HospitalData("RS Dr. Soetomo 2", "Kota Surabaya 2", "03131310002", "www.example2.com", "123-322"))
        partList.add(HospitalData("RS Dr. Soetomo 3", "Kota Surabaya 3", "03131310003", "www.example3.com", "123-323"))
        partList.add(HospitalData("RS Dr. Soetomo 4", "Kota Surabaya 4", "03131310004", "www.example4.com", "123-324"))
        partList.add(HospitalData("RS Dr. Soetomo 5", "Kota Surabaya 5", "03131310005", "www.example5.com", "123-325"))
        partList.add(HospitalData("RS Dr. Soetomo 6", "Kota Surabaya 6", "03131310006", "www.example6.com", "123-326"))
        return partList
    }
}