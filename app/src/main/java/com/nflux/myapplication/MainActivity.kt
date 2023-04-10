package com.nflux.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.nflux.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var todoDataList = arrayListOf(
        ToDoItem("To Do Content 1"),
        ToDoItem("To Do Content 2"),
        ToDoItem("To Do Content 3")
    )


    private lateinit var toDoItemCountTextView : TextView

    val toDoItemCnt = MutableLiveData<Int>(0)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // xml 파일에서 <data> <variable>에서 선언했던 ac 변수를 초기화합니다.
        binding.ac = this

        // binding의 생명주기를 설정합니다.
        // 아래 코드를 실행시 MainActivity의 생명주기를 따라가며
        // MainActivity가 활동중인 동안, UI 및 binding된 변수의 변동사항을 자동으로 업데이트 합니다.
        binding.lifecycleOwner = this

        // DataBinding을 사용할 경우 findViewById를 사용하여 객체를 등록하지 않아도 "binding.변환된ViewID"의 형태로 view에 접근 할 수 있습니다.
//        val editText = findViewById<EditText>(R.id.editText)
//        val button = findViewById<Button>(R.id.button)
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_todoList)

//        toDoItemCountTextView = findViewById<TextView>(R.id.textView_toDoCount)

        // toDoItemCountTextView 업데이트
        updateToDoItemCount()

        // RecyclerView Adapter 생성
        val adapter = MyAdapter(todoDataList)

        // RecyclerView 객체에 adapter 등록
        binding.recyclerViewTodoList.adapter = adapter

        adapter.notifyDataSetChanged()


        // 버튼 온클릭 이벤트 등록
        binding.button.setOnClickListener {

            // editText에 적힌 내용 가져오기
            val contents = binding.editText.text.toString()

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
                binding.editText.setText("")

                // toDoItemCountTextView 업데이트
                updateToDoItemCount()
            }

        }

    }

    // toDoItemCountTextView 업데이트
    private fun updateToDoItemCount(){
        // MutableLiveData Type의 변수는 아래와 같은 코드로 값을 변경 할 수 있습니다.
        // 변수.setValue(data) --> 변수.value = data (MainThread에서만 사용 가능하며, 빠르게 값이 변경됨)
        // 변수.postValue(data) (어떤 Thread에서든 사용 할 수 있으나, 값이 변경되는데 시간이 조금 걸림)

        // postValue 함수를 사용하여 DB/Network등 비동기 처리 작업 완료 후 결과값과 UI를 동기화하는데 사용 할 수 있습니다.
        toDoItemCnt.value = todoDataList.size
    }
}