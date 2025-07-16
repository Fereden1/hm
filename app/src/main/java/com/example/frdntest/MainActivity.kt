package com.example.frdntest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private val picturesList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
    )


    private lateinit var imgRandom: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgRandom = findViewById(R.id.randomImage)
    }
    //переход
    fun showRandomPicture(view: View) {
        val imageResId = picturesList.random()
        imgRandom.setImageResource(imageResId)
    }


    fun startNewActivity(view: View) {
        startActivity(Intent(this, SecondActivity::class.java))
    }


}
