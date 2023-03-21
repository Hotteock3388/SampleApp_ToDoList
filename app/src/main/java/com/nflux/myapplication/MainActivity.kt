package com.nflux.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 뷰 객체 등록
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        // 버튼 온클릭 이벤트 등록
        button.setOnClickListener {

            // editText에 적힌 내용 가져오기
            val contents = editText.text.toString()

            // contents가 공백이라면
            if (contents.isBlank()) {
                // 안내 메시지 출력
                Toast.makeText(baseContext, "Contents를 입력해주세요.", Toast.LENGTH_SHORT).show()

            } else {
                // content 내용 출력
                Toast.makeText(baseContext, contents, Toast.LENGTH_SHORT).show()

                // editText 비우기
                editText.setText("")
            }

        }

    }
}