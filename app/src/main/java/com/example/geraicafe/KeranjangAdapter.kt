package com.example.geraicafe

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KeranjangAdapter(private val context: Context, private val data: ArrayList<Data>) :
    RecyclerView.Adapter<KeranjangAdapter.Recy>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Recy {
        val view = LayoutInflater.from(context).inflate(R.layout.keranjangcustom, parent, false)
        return Recy(view)
    }

    override fun onBindViewHolder(v: Recy, position: Int) {
        val d = data[position]
        v.nameProduct.text = d.nameProduct
        v.harga.text = "Rp ${d.priceProduct}"
        v.jumlah.text = "1"

        v.gambarProduct.setImageResource(d.imagesProduct)
        v.itemView.setOnClickListener {
            val intent = Intent(context, Pembayaran::class.java)
            intent.putExtra("id", d.id)
            intent.putExtra("name", d.nameProduct)
            intent.putExtra("images", d.imagesProduct)
            intent.putExtra("price", d.priceProduct)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            context.startActivity(intent)
        }

        var angka = 1
        v.add.setOnClickListener {
            angka++
            v.jumlah.text = angka.toString()
        }

        v.min.setOnClickListener {
            if (angka > 1) {
                angka--
                v.jumlah.text = angka.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Recy(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val add: ImageView = itemView.findViewById(R.id.add)
        val min: ImageView = itemView.findViewById(R.id.min)
        val gambarProduct: ImageView = itemView.findViewById(R.id.gambarProduct)
        val nameProduct: TextView = itemView.findViewById(R.id.nameProduct)
        val harga: TextView = itemView.findViewById(R.id.harga)
        val jumlah: TextView = itemView.findViewById(R.id.totalJumlah)
    }
}
