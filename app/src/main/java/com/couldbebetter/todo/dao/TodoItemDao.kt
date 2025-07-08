package com.couldbebetter.todo.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.couldbebetter.todo.data.TodoItem

interface TodoItemDao {
    @Insert
    suspend fun addTodoItem(todoItem: TodoItem)

    @Update
    suspend fun updateTodoItem(todoItem: TodoItem)

    @Delete
    suspend fun deleteTodoItem(todoItem: TodoItem)

    @Query("SELECT * FROM todo_item ORDER BY id DESC")
    suspend fun getAllTodoItem(): LiveData<List<TodoItem>>

    @Query("SELECT * FROM todo_item WHERE id = :id")
    suspend fun getTodoItemById(id: Int): TodoItem
}