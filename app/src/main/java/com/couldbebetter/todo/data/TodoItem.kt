package com.couldbebetter.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity(tableName = "todo_item")
data class TodoItem(
    @PrimaryKey
    val id: Int,
    val title:String,
    val content: String,
    val date: String,
    val completed: Boolean
)