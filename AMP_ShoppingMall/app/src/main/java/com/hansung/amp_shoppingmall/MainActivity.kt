package com.hansung.amp_shoppingmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextBtn.setOnClickListener{
            val nextIntent = Intent(this, DetailActivity::class.java)
            nextIntent.putExtra("itemId", "outer1")
            startActivity(nextIntent)
        }


    }


}
