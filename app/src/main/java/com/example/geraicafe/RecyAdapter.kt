package com.example.geraicafe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyAdapter(private val context: Context, private val data: ArrayList<Data>) :
    RecyclerView.Adapter<RecyAdapter.RecHolder>() {

    private lateinit var dbOrder: DBorder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.recycustom, parent, false)
        return RecHolder(v)
    }

    override fun onBindViewHolder(holder: RecHolder, position: Int) {
        dbOrder = DBorder(context)
        val d = data[position]
        holder.images.setImageResource(d.imagesProduct)
        holder.title.text = d.nameProduct
        holder.harga.text = "Rp ${d.priceProduct}"
        holder.itemView.setOnClickListener {
            dbOrder.addOrder(d.id, d.nameProduct, d.imagesProduct, d.priceProduct)
            Toast.makeText(context, "Tersimpan => id:${d.id}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RecHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val images: ImageView = itemView.findViewById(R.id.gambar)
        val title: TextView = itemView.findViewById(R.id.nameproduk)
        val harga: TextView = itemView.findViewById(R.id.hargaproduk)
    }
}
