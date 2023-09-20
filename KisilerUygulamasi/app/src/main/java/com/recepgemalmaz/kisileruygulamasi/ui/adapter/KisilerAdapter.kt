package com.recepgemalmaz.kisileruygulamasi.ui.adapter

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.recepgemalmaz.kisileruygulamasi.data.entity.Kisiler
import com.recepgemalmaz.kisileruygulamasi.databinding.CardTasarimBinding
import com.recepgemalmaz.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.recepgemalmaz.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections

class KisilerAdapter(var mContext : Context, var kisilerListesi : List<Kisiler>)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {//position : hangi satırda olduğumuzu gösterir
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim
        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_Tel

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET") {
                    sil(kisi.kisi_id)
                }.show()
        }

        t.cardViewSatir.setOnClickListener {
            //gecis islemi
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi= kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

    }
    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    fun sil(kisi_id : Int){
        Log.e("Kişi Sil", "${kisi_id.toString()}")
    }
}