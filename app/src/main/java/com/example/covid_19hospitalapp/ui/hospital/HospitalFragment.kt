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
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, hospitalData.hospitalPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, hospitalData.hospitalName.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, hospitalData.hospitalAddress.toString())
        showDetailActivity.putExtra(Intent.EXTRA_PACKAGE_NAME, hospitalData.hospitalContact.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, hospitalData.hospitalWeb.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, hospitalData.hospitalMap.toString())
        startActivity(showDetailActivity)
    }

    private fun createHospitalData() : List<HospitalData> {
        val partList = ArrayList<HospitalData>()
        partList.add(HospitalData(R.drawable.rs1, "RSUD Dr. Soetomo", "Kota Surabaya", "0315501078", "http://rsudrsoetomo.jatimprov.go.id/", "123-321"))
        partList.add(HospitalData(R.drawable.rs2, "Rumah Sakit Khusus Infeksi Universitas Airlangga", "Kota Surabaya", "0315961389", "https://rumahsakit.unair.ac.id/", "123-322"))
        partList.add(HospitalData(R.drawable.rs3, "Rumah Sakit Umum Daerah Sidoarjo", "Kabupaten Sidoarjo", "0318961649", "http://rsd.sidoarjokab.go.id/", "123-323"))
        partList.add(HospitalData(R.drawable.rs4, "RSUD Dr. Saiful Anwar Malang", "Kota Malang", "0341362101", "https://rsusaifulanwar.jatimprov.go.id/", "123-324"))
        partList.add(HospitalData(R.drawable.rs5, "RSUD Kabupaten Kediri", "Kota Kediri", "0354391718", "https://rsud.kedirikab.go.id/", "123-325"))
        partList.add(HospitalData(R.drawable.rs6, "RSUD Dr. R. KOESMA Tuban", "Kabupaten Tuban", "0356321010", "https://rsudkoesma.id/", "123-326"))
        partList.add(HospitalData(R.drawable.rs7, "RSUD Dr R. Sosodoro Djatikoesoemo Bojonegoro", "Kabupaten Bojonegoro", "03533412133", "https://www.rssosodoro.com/", "123-327"))
        partList.add(HospitalData(R.drawable.rs8, "RSUD Dr. Iskak Kab. Tulungagung", "Kabupaten Tulungagung", "0355322609", "https://rsudtulungagung.com/", "123-328"))
        partList.add(HospitalData(R.drawable.rs9, "RSUD Dr.Soedono Madiun", "Kota Madiun", "0351454657", "https://rssoedono.jatimprov.go.id/", "123-329"))
        return partList
    }
}
