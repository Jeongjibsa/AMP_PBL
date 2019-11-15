package com.hansung.amp_shoppingmall.detail
<<<<<<< HEAD
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(var productName: String,
                var itemName: String,
                var itemPrice: String,
                var itemBigClass: String,
                var itemSmallClass: String,
                var itemStock: String): Parcelable {}
=======

class Item (val productName: String,
            val itemName: String,
            val itemPrice: String,
            val itemBigClass: String,
            val itemSmallClass: String,
            val itemStock: String)
>>>>>>> 0f6ef1ea7c195ec516cd726e018afd23ac1e8d1b
