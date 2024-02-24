package com.example.geraicafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.geraicafe.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(View.OnClickListener {
            if (binding.nama.text.toString() == "sylvina" &&
                binding.email.text.toString() == "sylvnmnd25@gmail.com" &&
                binding.password.text.toString() == "12345"
            ) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this, "Login Gagal!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}