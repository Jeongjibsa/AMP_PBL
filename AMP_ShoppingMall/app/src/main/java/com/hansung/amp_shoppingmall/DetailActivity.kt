package com.hansung.amp_shoppingmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var itemId: String

        if (intent.hasExtra("itemId")) {
            itemId = intent.getStringExtra("itemId")
            Toast.makeText(this, "전달된 데이터 + $itemId", Toast.LENGTH_SHORT).show()
            //받아온 item정보로 텍스트뷰 채우기
            /*
            itemNameTextView.setText("이름 : $value")
            itemPriceTextView.setText("가격 : $value")
            itemClassTextView.setText("종류 : $value")
            itemStockTextView.setText("재고 : $value")
            */

        } else {
            Toast.makeText(this, "전달된 데이터가 없습니다 이전화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show()
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }


    }


    /*override fun onStart() {
        super.onStart()

        // Read from the database
        itemRootRef.addValueEventListener(object : ChildEventListener {

            override fun onChildChanged(dataSnapshot: DataSnapshot, p1: String?) {

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }
        })


        // Read from the database
        mItemNameRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                itemNameTextView.setText("이름 : $value")
                Log.d("ahn", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }
        })

        // Read from the database
        mItemPriceRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                //itemPriceTextView.setText("가격 : $value")
                Log.d("ahn", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }
        })


        // Read from the database
        mItemClassRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                //itemClassTextView.setText("종류 : $value")
                Log.d("ahn", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }
        })


        // Read from the database
        mItemStockRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                //itemStockTextView.setText("재고 : $value")
                Log.d("ahn", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }
        })


    }*/

    val postListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            val value = dataSnapshot.getValue(String::class.java)
            //itemStockTextView.setText("재고 : $value")
            Log.d("ahn", "Value is: $value")
        }

        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w("ahn", "Failed to read value.", error.toException())
        }
    }
}
