package com.nflux.myapplication


import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: ArrayList<ToDoItem>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_todo_list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, itemPosition: Int) {
        holder.bind(dataList[itemPosition])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(data: ToDoItem){

            val content = itemView.findViewById<TextView>(R.id.textView_todo_content)

            content.text = data.content

            itemView.setOnClickListener {

                if(!data.isCleared){
                    //To Do 목표 달성 -> TextView에 취소선 긋기
                    content.paintFlags = content.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }else{
                    //To Do 목표 달성 취소
                    content.paintFlags = 0
                }

                data.isCleared = !data.isCleared
            }

        }
    }
}
