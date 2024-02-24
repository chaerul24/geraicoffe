package com.example.geraicafe

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private var bottomNavi: BottomNavigationView? = null
    private var container: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        DBorder(this)
        container = findViewById<View>(R.id.container) as FrameLayout
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
        bottomNavi = findViewById<View>(R.id.bottomNav) as BottomNavigationView
        bottomNavi!!.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            private var fg: Fragment? = null
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                println("item id => " + item.itemId)
                fg = Fragment()
                when (item.itemId) {
                    R.id.home -> fg = HomeFragment()
                    R.id.menu -> fg = Menu()
                    R.id.favorite -> fg = FavoriteFragment()
                    R.id.keranjang -> fg = KeranjangFragment2()
                    R.id.nama2 -> fg = ProfilFragment()
                }
                supportFragmentManager.beginTransaction().replace(R.id.container, fg!!).commit()
                return true
            }
        })
    }
}