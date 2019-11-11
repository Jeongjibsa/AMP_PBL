package com.hansung.amp_shoppingmall

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
import android.widget.Button
import android.widget.TextView
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
 /*   private val mRootRef = FirebaseDatabase.getInstance().getReference();
    private val mCategoryRef = mRootRef.child("category");*/
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
    /*private fun init() { //파이어 베이스에서 이미지와 데이터를 가져와 Data클래스로 변환후 arraylist에 추가

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(linearLayoutManager)

        val postListener = object: ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //val post = dataSnapshot.getValue(Post::class.java)
                for(messageData: DataSnapshot in dataSnapshot.children){
                    Log.e("test","parent"+dataSnapshot.key.toString()+",||||||||||||||||||||||child : "+messageData.getValue().toString())

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {


            }
        }
        mCategoryRef.addValueEventListener(postListener)
        recyclerView.setAdapter(adapter)

    }*/


    ////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton
        searchView

        val searchClickListener = SearchClickListener()
        searchButton!!.setOnClickListener(searchClickListener)

        initDatabase()

        //getData()

    }



    fun UpdateProductArray(msg: String) {
        //msg로 파이어베이스에서 데이터들을 가져와서 arraylist에 저장
    }

    private inner class SearchClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            val searchMessage = searchView!!.getText().toString()
            //검색버튼 클릭시 해당 이름으로 리스트 뷰 를 작성


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
