package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.target.CustomTarget
import com.example.myapplication.MainActivity3
import com.example.myapplication.MainActivity4
import com.example.myapplication.MainActivity6
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream

@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {

    lateinit var img:ImageView
    lateinit var img2:ImageView
    lateinit var img3:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
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






        val nextPageBtn = findViewById<View>(R.id.button4) as ImageButton
        nextPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity, MainActivity3::class.java)
            startActivity(intent)
        }
        val nextPageBtn1 = findViewById<View>(R.id.button5) as ImageButton
        nextPageBtn1.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity, MainActivity4::class.java)
            startActivity(intent)
        }
        val nextPageBtn2 = findViewById<View>(R.id.button3) as Button
        nextPageBtn2.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity, MainActivity6::class.java)
            startActivity(intent)
        }
    }



}
