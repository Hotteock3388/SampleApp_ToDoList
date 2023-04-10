package com.nflux.myapplication

open class RecyclerViewItemEventListener
    : MyAdapter.MyViewHolder.RecyclerViewItemEvent {

    override fun onItemClick(data: ToDoItem) {}

}