package com.nflux.myapplication


data class ToDoItem(
    var content : String,
    var isCleared : Boolean = false
)