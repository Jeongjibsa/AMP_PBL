package com.hansung.amp_shoppingmall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hansung.amp_shoppingmall.detail.Item

class SecondRecyclerAdapter(
    val context: Context,
    val itemList: ArrayList<Item>,
    val itemClick: (Item) -> Unit
) :
    RecyclerView.Adapter<SecondRecyclerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_category_clicked, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position], context)
    }

    inner class Holder(itemView: View, itemClick: (Item) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val itemImg = itemView?.findViewById<ImageView>(R.id.img_item)
        val itemTitle = itemView?.findViewById<TextView>(R.id.title_item)
        val itemContent1 = itemView?.findViewById<TextView>(R.id.content1_item)
        val itemContent2 = itemView?.findViewById<TextView>(R.id.content2_item)

        fun bind(item: Item, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
//            if (item.img != "") {
//                val resourceId =
//                    context.resources.getIdentifier(item.img, "drawable", context.packageName)
//                itemImg?.setImageResource(resourceId)
//            } else {
//                itemImg?.setImageResource(R.mipmap.ic_launcher_round)
//            }
            itemImg?.setImageResource(R.mipmap.ic_launcher_round)
            /* 나머지 TextView와 String 데이터를 연결한다. */
            itemTitle?.text = item.itemName
            itemContent1?.text = item.itemPrice
            itemContent2?.text = item.itemStock

            itemView.setOnClickListener { itemClick(item) }
        }
    }
}