package com.nflux.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var todoDataList = arrayListOf(
        ToDoItem("To Do Content 1"),
        ToDoItem("To Do Content 2"),
        ToDoItem("To Do Content 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 뷰 객체 등록
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_todoList)

        // RecyclerView Adapter 생성
        val adapter = MyAdapter(todoDataList)

        // RecyclerView 객체에 adapter 등록
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()


        // 버튼 온클릭 이벤트 등록
        button.setOnClickListener {

            // editText에 적힌 내용 가져오기
            val contents = editText.text.toString()

            // contents가 공백이라면
            if (contents.isBlank()) {
                // 안내 메시지 출력
                Toast.makeText(baseContext, "Contents를 입력해주세요.", Toast.LENGTH_SHORT).show()

            } else {
                // todoDataList에 항목 추가
                todoDataList.add(ToDoItem(contents))

                // todoDataList에 항목 추가
                adapter.notifyDataSetChanged()

                // editText 비우기
                editText.setText("")
            }

        }

    }
}