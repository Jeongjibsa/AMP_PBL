package com.hansung.amp_shoppingmall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRootRef = FirebaseDatabase.getInstance().getReference();
    val mConditionRef = mRootRef.child("condition");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        // Read from the database
        mConditionRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                textViewCondition.setText(value)
                Log.d("ahn", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ahn", "Failed to read value.", error.toException())
            }


        })

        buttonSunny.setOnClickListener {
            mConditionRef.setValue("Sunny")
        }
        buttonFoggy.setOnClickListener {
            mConditionRef.setValue("Foggy")
        }

    }
}
