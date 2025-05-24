package com.couldbebetter.todo.data

import java.util.Date

data class TodoItem(
    val title:String,
    val content: String,
    val date: String,
    val completed: Boolean
)