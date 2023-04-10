package com.nflux.myapplication


import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nflux.myapplication.databinding.LayoutTodoListItemBinding

class MyAdapter(private val dataList: ArrayList<ToDoItem>, private val event : RecyclerViewItemEventListener)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val b = DataBindingUtil.inflate<LayoutTodoListItemBinding>(LayoutInflater.from(parent.context), R.layout.layout_todo_list_item, parent, false)
        return MyViewHolder(b, event)
    }

    override fun onBindViewHolder(holder: MyViewHolder, itemPosition: Int) {
        holder.bind(dataList[itemPosition])
    }

    class MyViewHolder(private val binding : LayoutTodoListItemBinding, private val event: RecyclerViewItemEventListener): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ToDoItem){

            binding.textViewTodoContent.text = data.content

            binding.event = event
            binding.data = data

        }

        interface RecyclerViewItemEvent{
            fun onItemClick(data: ToDoItem)
        }
    }
}
