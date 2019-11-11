package com.hansung.amp_shoppingmall.detail
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(var productName: String,
                var itemName: String,
                var itemPrice: String,
                var itemBigClass: String,
                var itemSmallClass: String,
                var itemStock: String): Parcelable {}