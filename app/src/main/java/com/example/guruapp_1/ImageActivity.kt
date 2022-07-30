package com.example.guruapp_1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_image.*
import java.io.File

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val imgFile1 = File("/data/user/0/com.example.guruapp_1/cache/" + StaffCafeteria().staffImgName1)
        val imgFile2 = File("/data/user/0/com.example.guruapp_1/cache/" + StaffCafeteria().staffImgName2)
        val path1 = BitmapFactory.decodeFile(imgFile1.getAbsolutePath())
        val path2 = BitmapFactory.decodeFile(imgFile2.getAbsolutePath())

        val img = when(intent.getIntExtra("pos", 1)) { // intent로 넘어온 pos값을 사용하여 보여줄 Image를 지정
            1 -> path1
            else -> path2
        }
        image_full.setImageBitmap(img)

        image_full.setOnClickListener {
            supportFinishAfterTransition() // 클릭 시 본래 Finish() 역할을 하는 supportFinishAfterTransition()을 사용하여 마찬가지로 애니메이션을 주며 원래 엑티비티로 돌아감
        }

    }

}