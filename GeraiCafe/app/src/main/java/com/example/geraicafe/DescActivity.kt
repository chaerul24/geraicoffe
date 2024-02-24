package com.example.geraicafe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geraicafe.databinding.ActivityDescBinding

class DescActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignin.setOnClickListener {
            goToLoginPage()
        }

        binding.btnSignup.setOnClickListener {
            goToRegisterPage()
        }
    }
    private fun goToRegisterPage() {
        val intent = Intent(this, SignupActivity:: class.java)
        startActivity(intent)
    }
    private fun goToLoginPage() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}



