package com.example.geraicafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geraicafe.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnRegister.setOnClickListener {
            val db = DBHelper(this, null)
            val uname = binding.nama.text.toString()
            val mail = binding.email.text.toString()
            val pass = binding.password.text.toString()
// Menambahkan data ke database
            val isAddedSuccessfully = db.addData(uname, mail, pass)

            if (isAddedSuccessfully) {
// Jika data berhasil ditambahkan, pindah ke halaman login
                goToLoginPage()
            } else {
// Jika data tidak berhasil ditambahkan, tampilkan pesan kesalahan
                Toast.makeText(
                    this, "Gagal menambahkan data ke database",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.btnRegister.setOnClickListener {
            goToLoginPage()
        }
    }
    private fun goToLoginPage() {
        val intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }
}
