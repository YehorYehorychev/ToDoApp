package com.yehorychev.importanttodos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodosDao {

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)

    @Query("SELECT * FROM todos_table WHERE id = :todoId")
    fun get(todoId: Long): LiveData<Todo>

    @Query("SELECT * FROM todos_table ORDER BY id DESC")
    fun getAll(): LiveData<List<Todo>>
}