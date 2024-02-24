package com.example.geraicafe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KeranjangFragment2 : Fragment() {
    private lateinit var recy: RecyclerView
    private lateinit var data: ArrayList<Data>
    private lateinit var adapter: KeranjangAdapter
    private lateinit var db: DBorder
    private lateinit var harga: TextView
    private lateinit var pesanan: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.cart_order, container, false)
        db = DBorder(requireContext())
        recy = view.findViewById(R.id.recy)

        var pesanan_ = db.totalPesanan()
        var harga_ = db.totalHarga();

        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recy.layoutManager = linearLayoutManager

        data = ArrayList()

        db.getReadProduct(data)
        adapter = KeranjangAdapter(requireContext(), data)
        recy.adapter = adapter
        pesanan = view.findViewById(R.id.total_pesanan)
        pesanan.text = "Pesanan ${db.totalPesanan()}"
        harga = view.findViewById(R.id.total_harga)
        harga.text = "Total: Rp ${db.totalHarga()}"

        val cartBtn: Button = view.findViewById(R.id.pesan)
        cartBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val i = Intent(context, Pembayaran::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                context?.startActivity(i)
            }

        })

        return view
    }
}
