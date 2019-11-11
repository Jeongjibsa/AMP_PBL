package com.hansung.amp_shoppingmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.widget.ListView
import com.google.firebase.database.*
import com.hansung.amp_shoppingmall.detail.Item
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var mItemReference : DatabaseReference
    private lateinit var mChild: ChildEventListener

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    var itemList = arrayListOf<Item>()

    private fun initDatabase() {
        mDatabase = FirebaseDatabase.getInstance()
        mItemReference = mDatabase.getReference("category")

        mItemReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(category:DataSnapshot in dataSnapshot.getChildren()){
                    val productName = category.getKey().toString()
                    Log.e("ahn","productName : ${productName}")
                    val bigClass = category.child("bigClass").getValue().toString()
                    Log.e("ahn","bigClass : ${bigClass}")
                    val smallClass = category.child("smallClass").getValue().toString()
                    val name = category.child("name").getValue().toString()
                    val price = category.child("price").getValue().toString()
                    val stock = category.child("stock").getValue().toString()

                    itemList.add(Item(productName, name, price, bigClass, smallClass, stock))
                // Item (val itemName: , val itemPrice: , val itemBigClass: , val itemSmallClass: ,  val itemStock: )
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*nextBtn.setOnClickListener{
            val nextIntent = Intent(this, DetailActivity::class.java)
            nextIntent.putExtra("itemId", "outer1")
            startActivity(nextIntent)
        }*/

        initDatabase()
        Log.e("ahn", "start")
        /*for(i:Item in itemList){
            Log.e("ahn", "main ItemList : ${i.productName}, ${i.itemStock}")
            println("main ItemList : ${i.productName}, ${i.itemStock}")
        }*/

        for(i:String in arrayList){
            Log.e("ahn", "main arrayList ${i.toString()}, $i")
        }
        Log.e("ahn", "end")
    }


}
