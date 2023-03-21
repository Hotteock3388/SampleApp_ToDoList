package com.nflux.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: ArrayList<String>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_todo_list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, itemPosition: Int) {
        holder.bindItemStatusListItems(dataList[itemPosition])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindItemStatusListItems(data: String){

            val content = itemView.findViewById<TextView>(R.id.textView_todo_content)

            content.text = data

        }
    }
}
