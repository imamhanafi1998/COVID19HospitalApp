package com.example.covid_19hospitalapp.ui.hospital

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covid_19hospitalapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HospitalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_hospital, container, false)
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
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, hospitalData.hospitalMapLat.toString())
        showDetailActivity.putExtra(Intent.EXTRA_BCC, hospitalData.hospitalMapLong.toString())
        startActivity(showDetailActivity)
    }

    private fun createHospitalData() : List<HospitalData> {
        val partList = ArrayList<HospitalData>()
        partList.add(HospitalData(R.drawable.rs1, "RSUD Dr. Soetomo", "Kota Surabaya", "0315501078", "http://rsudrsoetomo.jatimprov.go.id/", "-7.268021", "112.758500"))
        partList.add(HospitalData(R.drawable.rs2, "Rumah Sakit Khusus Infeksi Universitas Airlangga", "Kota Surabaya", "0315961389", "https://rumahsakit.unair.ac.id/", "-7.270191", "112.786139"))
        partList.add(HospitalData(R.drawable.rs3, "Rumah Sakit Umum Daerah Sidoarjo", "Kabupaten Sidoarjo", "0318961649", "http://rsd.sidoarjokab.go.id/", "-7.465429", "112.716379"))
        partList.add(HospitalData(R.drawable.rs4, "RSUD Dr. Saiful Anwar Malang", "Kota Malang", "0341362101", "https://rsusaifulanwar.jatimprov.go.id/", "-7.972562", "112.631550"))
        partList.add(HospitalData(R.drawable.rs5, "RSUD Kabupaten Kediri", "Kota Kediri", "0354391718", "https://rsud.kedirikab.go.id/", "-7.759709", "112.176110"))
        partList.add(HospitalData(R.drawable.rs6, "RSUD Dr. R. KOESMA Tuban", "Kabupaten Tuban", "0356321010", "https://rsudkoesma.id/", "-6.898737", "112.046514"))
        partList.add(HospitalData(R.drawable.rs7, "RSUD Dr R. Sosodoro Djatikoesoemo Bojonegoro", "Kabupaten Bojonegoro", "03533412133", "https://www.rssosodoro.com/", "-7.159506", "111.899632"))
        partList.add(HospitalData(R.drawable.rs8, "RSUD Dr. Iskak Kab. Tulungagung", "Kabupaten Tulungagung", "0355322609", "https://rsudtulungagung.com/", "-8.054871", "111.918112"))
        partList.add(HospitalData(R.drawable.rs9, "RSUD Dr.Soedono Madiun", "Kota Madiun", "0351454657", "https://rssoedono.jatimprov.go.id/", "-7.626299", "111.524001"))
        return partList
    }
}
