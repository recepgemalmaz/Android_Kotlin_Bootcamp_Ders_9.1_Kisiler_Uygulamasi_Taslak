package com.recepgemalmaz.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.recepgemalmaz.kisileruygulamasi.R
import com.recepgemalmaz.kisileruygulamasi.data.entity.Kisiler
import com.recepgemalmaz.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.recepgemalmaz.kisileruygulamasi.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        //binding.rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //binding.rv.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)


        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Recep", "0532 532 32 32")
        val k2 = Kisiler(2, "Ahmet", "0532 532 32 32")
        val k3 = Kisiler(3, "Mehmet", "0532 532 32 32")

        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val kisilerAdapter = KisilerAdapter(requireContext(), kisilerListesi)
        binding.rv.adapter = kisilerAdapter


        binding.fab.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.kisiKayitFragment)
        }


        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {//Harf Girdikce ve sildikce calisir
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Arama butonuna basildiginda calisir
                ara(query)
                return false
            }
        })
        return binding.root
    }

    fun ara(aramaKelimesi: String) {
        Log.e("Kisi Ara", aramaKelimesi)
    }
    override fun onResume() {
        super.onResume()
        Log.e("Kisi Anasayfa", "Donuldu")
    }

}