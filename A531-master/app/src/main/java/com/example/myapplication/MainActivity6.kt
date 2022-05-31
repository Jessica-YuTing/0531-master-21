package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.myapplication.MainActivity5

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val nextPageBtn = findViewById<View>(R.id.button6) as Button
        nextPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity6, MainActivity5::class.java)
            startActivity(intent)
        }
    }
}