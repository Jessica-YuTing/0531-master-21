package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import android.os.Bundle
import android.widget.GridView
import com.example.myapplication.ImageAdapter
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.request.target.CustomTarget
import com.example.myapplication.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity5 : AppCompatActivity() {
    var curView: ImageView? = null //預設蓋牌
    private var countPair = 0 //答對總數預設0

    val drawable = intArrayOf(
        R.drawable.sample_0, R.drawable.sample_1,
        R.drawable.sample_2, R.drawable.sample_3
    )
    var pos = intArrayOf(0, 1, 2, 3, 0, 1, 2, 3)
    var currentPos = -1 //預設-1是沒選任何東西
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val gridView = findViewById<View>(R.id.gridView) as GridView
        val imageAdapter = ImageAdapter(this)
        gridView.adapter = imageAdapter
        gridView.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            if (currentPos < 0) { //當currentPos < 0 就會開始看是否選對 選錯直接蓋牌 選對則亮牌
                currentPos = position //比較是否一致
                curView = view as ImageView //秀出當前的牌
                view.setImageResource(drawable[pos[position]]) //一致 2張秀出
            } else {  //當currentPos > 0 條件
                if (currentPos == position) { //如果第一張 與 第二張 一致
                    (view as ImageView).setImageResource(R.drawable.hidden) //2張秀出
                } else if (pos[currentPos] != pos[position]) { //不一致
                    curView!!.setImageResource(R.drawable.hidden) //蓋牌
                } else {
                    (view as ImageView).setImageResource(drawable[pos[position]])
                    countPair++
                    if (countPair == 4) {
                        Handler().postDelayed({
                            val mainIntent = Intent(this@MainActivity5, MainActivity::class.java)
                            startActivity(mainIntent)
                            finish() // 當跳到 MainActivity2 時，讓 MainActivity5 這隻程式結束。
                            // 這樣設計可以方便使用者。
                        }, 2000) //2s
                    }
                }
                currentPos = -1
            }
        }
    }
}