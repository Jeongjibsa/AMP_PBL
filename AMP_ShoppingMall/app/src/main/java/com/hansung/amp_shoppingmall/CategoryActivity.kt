package com.hansung.amp_shoppingmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.FirebaseDatabase
import com.hansung.amp_shoppingmall.detail.Item
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    var itemList = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        if (intent.hasExtra("itemList")) {
            itemList = intent.getParcelableArrayListExtra<Item>("itemList")
        }


        val mAdapter = FirstRecyclerAdapter(this, itemList) { item ->
            //             Toast.makeText(this, "테스트중입니다.", Toast.LENGTH_SHORT).show()
            val nextIntent = Intent(this, SubActivity::class.java)
            nextIntent.putExtra("itemList", itemList)
            startActivity(nextIntent)
        }
        mRecyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        mRecyclerView.layoutManager = lm
        mRecyclerView.setHasFixedSize(true)
    }
}
