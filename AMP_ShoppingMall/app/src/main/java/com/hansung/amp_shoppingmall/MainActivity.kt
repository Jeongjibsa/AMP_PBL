package com.hansung.amp_shoppingmall

<<<<<<< HEAD
=======
import android.content.Context
>>>>>>> mgpark
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
<<<<<<< HEAD
import android.view.View
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.hansung.amp_shoppingmall.detail.Item
import kotlinx.android.synthetic.main.activity_main.*
=======
import android.widget.ListView
import com.google.firebase.database.*
import com.hansung.amp_shoppingmall.detail.Item
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



>>>>>>> 0f6ef1ea7c195ec516cd726e018afd23ac1e8d1b

import java.util.ArrayList
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var mItemReference : DatabaseReference
    private lateinit var mChild: ChildEventListener

<<<<<<< HEAD

    private var adapter: RecyclerAdapter = RecyclerAdapter()
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var mItemReference : DatabaseReference
    private var context : Context = this
    private lateinit var searchClickListener: SearchClickListener

    var itemList = arrayListOf<Item>()

    private fun initDatabase() {
        mDatabase = FirebaseDatabase.getInstance()
        mItemReference = mDatabase.getReference("category")

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(linearLayoutManager)

        val postListener = object : ValueEventListener {
=======
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    var itemList = arrayListOf<Item>()

    private fun initDatabase() {
        mDatabase = FirebaseDatabase.getInstance()
        mItemReference = mDatabase.getReference("category")

        mItemReference.addValueEventListener(object : ValueEventListener {
>>>>>>> 0f6ef1ea7c195ec516cd726e018afd23ac1e8d1b
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
<<<<<<< HEAD
                    // Item (val itemName: , val itemPrice: , val itemBigClass: , val itemSmallClass: ,  val itemStock: )
                    adapter!!.addItem(Item(productName, name, price, bigClass, smallClass, stock))
                }
                adapter!!.notifyDataSetChanged()
=======
                // Item (val itemName: , val itemPrice: , val itemBigClass: , val itemSmallClass: ,  val itemStock: )
                }

>>>>>>> 0f6ef1ea7c195ec516cd726e018afd23ac1e8d1b
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }
        }

<<<<<<< HEAD
        mItemReference.addValueEventListener(postListener)
        recyclerView.setAdapter(adapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*searchButton
        searchView*/

        searchClickListener = SearchClickListener()
        searchButton!!.setOnClickListener(searchClickListener)

        initDatabase()  // arraylist에 데이터를 넣고 리사이클러 어댑터를 초기화 한다.

        categoryButton.setOnClickListener {
            val nextIntent = Intent(this, CategoryActivity::class.java)
            nextIntent.putExtra("itemList", itemList)
            startActivity(nextIntent)
        }
    }



    fun UpdateProductArray(msg: String) {
        //msg로 파이어베이스에서 데이터들을 가져와서 arraylist에 저장
    }

    private inner class SearchClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            val searchMessage = searchView!!.text.toString()
            //var searchedList = ArrayList<Item>()
            var flag:Boolean = false;
            var tempAdapter:RecyclerAdapter = RecyclerAdapter()
            for(searchedItem:Item in itemList){

                if(searchedItem.itemName.equals(searchMessage) || searchedItem.itemBigClass.equals(searchMessage) || searchedItem.itemSmallClass.equals(searchMessage) || searchedItem.productName.equals(searchMessage))  {
                    //searchedList.add(item)
                    tempAdapter.addItem(searchedItem)
                    flag = true
                    Log.e("test","item BigClass = " + searchedItem.itemBigClass + ", searchMessage = " + searchMessage)
                }

            }
            if(!flag) Toast.makeText(context ,"검색결과가 없습니다.", Toast.LENGTH_LONG).show()
            else adapter = tempAdapter
            adapter!!.notifyDataSetChanged()
            recyclerView.setAdapter(adapter)
        }
=======
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
>>>>>>> 0f6ef1ea7c195ec516cd726e018afd23ac1e8d1b
    }


}
