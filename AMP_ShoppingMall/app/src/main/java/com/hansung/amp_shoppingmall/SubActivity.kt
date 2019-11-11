package com.hansung.amp_shoppingmall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hansung.amp_shoppingmall.detail.Item
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    var itemList = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if (intent.hasExtra("itemList")) {
            itemList = intent.getParcelableArrayListExtra<Item>("itemList")
        }

        val mAdapter = SecondRecyclerAdapter(this, itemList) { item ->
            Toast.makeText(this, "테스트중입니다.", Toast.LENGTH_SHORT).show()
        }
        mRecyclerView2.adapter = mAdapter

//        val lm = LinearLayoutManager(this)
        val lm = GridLayoutManager(this, 2)

        mRecyclerView2.layoutManager = lm
//        mRecyclerView2.setHasFixedSize(true)
    }

}
