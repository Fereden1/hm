package com.example.frdntest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.frdntest.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        binding.emailOutput.setText(email)
        binding.passwordOutput.setText(password)
    }
}
