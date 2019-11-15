package com.hansung.amp_shoppingmall



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import com.bumptech.glide.Glide
//import com.google.firebase.storage.FirebaseStorage
import com.hansung.amp_shoppingmall.detail.Item
import kotlinx.android.synthetic.main.activity_detail.*
/*import com.google.firebase.storage.StorageReference
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.storage.FileDownloadTask
import com.google.android.gms.tasks.OnSuccessListener
import java.io.File
import android.net.Uri
import android.util.Log
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser*/


class DetailActivity : AppCompatActivity() {

    private var itemList = arrayListOf<Item>()
    lateinit var productName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (intent.hasExtra("itemList")) {
            itemList = intent.getParcelableArrayListExtra<Item>("itemList")
            productName = intent.getStringExtra("productName")
            //Toast.makeText(this, "전달된 데이터 + $itemList", Toast.LENGTH_SHORT).show()
            //받아온 item정보로 텍스트뷰 채우기

            var imageName: String? = null
            for(i: Item in itemList){
                if(i.productName.equals(productName)){
                    itemNameTextView.setText("이름 : ${i.itemName}")
                    itemPriceTextView.setText("가격 : ${i.itemPrice}")
                    itemClassTextView.setText("종류 : ${i.itemBigClass}/${i.itemSmallClass}")
                    itemStockTextView.setText("재고 : ${i.itemStock}")
                    imageName = i.itemName
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////
            //이미지 로딩부분
            /*val mStorageRef: StorageReference = FirebaseStorage.getInstance().reference

            val firebaseStorage = FirebaseStorage.getInstance()
            Log.e("ahn","firebaseStorage reading")
            // 위의 저장소를 참조하는 파일명으로 지정
            val storageReference = firebaseStorage.reference.child("image/" + imageName + ".jpg")
            Log.e("ahn","storageReference reading")

            storageReference.getBytes(Long.MAX_VALUE).addOnSuccessListener {
                // Use the bytes to display the image
                Glide.with(this@DetailActivity)
                    .load(R.drawable.test)//task.result
                    .into(itemImageView)

            }.addOnFailureListener {
                // Handle any errors
            }*/

            /* storageReference.downloadUrl.addOnCompleteListener(object: OnCompleteListener<Uri>{
                 override fun onComplete(task:Task<Uri>){
                     Log.e("ahn","listener's onComplete")
                     if(task.isComplete){
                         Log.e("ahn","listener's onComplete -> if")
                         Glide.with(this@DetailActivity)
                             .load(R.drawable.test)//task.result
                             .into(itemImageView)
                     }
                     else{
                         Log.e("ahn","listener's onComplete -> else")
                         Toast.makeText(this@DetailActivity, "이미지 로딩 실패", Toast.LENGTH_SHORT)
                             .show()
                     }
                 }
             })*/


            //StorageReference에서 파일 다운로드 URL 가져옴
            /*storageReference.downloadUrl.addOnCompleteListener { task ->
                Log.e("ahn","CompleteListener call")
                if (task.isSuccessful) {
                    Log.e("ahn","-> if")
                    // Glide 이용하여 이미지뷰에 로딩
                    Glide.with(this@DetailActivity)
                        .load(R.drawable.test)//task.result
                        .into(itemImageView)
                } else {
                    Log.e("ahn","-> else")
                    // URL을 가져오지 못하면 토스트 메세지
                    Toast.makeText(this@DetailActivity, "이미지 로딩 실패", Toast.LENGTH_SHORT)
                        .show()
                }
            }*/
            /////////////////////////////////////////////////////////////////////////////////////////////////////

        } else {
            Toast.makeText(this, "전달된 데이터가 없습니다 이전화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show()
            val nextIntent = Intent(this, MainActivity::class.java)
            startActivity(nextIntent)
        }


    }

}
