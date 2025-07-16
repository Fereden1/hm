package com.example.frdntest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private val picturesList = listOf(
        "https://loremflickr.com/800/500",
        "https://loremflickr.com/801/500",
        "https://loremflickr.com/802/500",
        "https://loremflickr.com/803/500",
        "https://loremflickr.com/804/500",
        "https://loremflickr.com/805/500",
        "https://loremflickr.com/806/500",
        "https://loremflickr.com/807/500",
        "https://loremflickr.com/808/500",
        "https://loremflickr.com/809/500"
    )

    private lateinit var imgRandom: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgRandom = findViewById(R.id.randomImage)
    }

    fun showRandomPicture(view: View) {
        val url = picturesList.random()
        Glide.with(this).load(url).into(imgRandom)
    }

    fun startNewActivity(view: View) {
        startActivity(Intent(this, SecondActivity::class.java))
    }


}
