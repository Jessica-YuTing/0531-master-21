package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.request.target.CustomTarget
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

class MainActivity3 : AppCompatActivity() {

    lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        img = findViewById(R.id.img1)
        GlideApp.with(this)
            .asBitmap()
            .load(R.drawable.backg)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap,
                                             transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?) {
                    img.setImageBitmap(resource)


                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })
        val nextPageBtn = findViewById<View>(R.id.button13) as Button
        nextPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity3, MainActivity7::class.java)
            startActivity(intent)
        }
    }

}