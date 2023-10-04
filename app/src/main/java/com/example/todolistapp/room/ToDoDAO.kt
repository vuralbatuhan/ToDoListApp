package com.example.todolistapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolistapp.data.entity.ToDoModel

@Dao
interface ToDoDAO {

    @Query("SELECT * FROM todos")
    suspend fun todoYukle(): List<ToDoModel>

    @Insert
    suspend fun kaydet(todo: ToDoModel)

    @Update
    suspend fun guncelle(todo: ToDoModel)

    @Delete
    suspend fun sil(todo: ToDoModel)

    @Query("SELECT * FROM todos WHERE todo_name like '%' || :aramaKelimesi ||'%'")
    suspend fun ara(aramaKelimesi: String) : List<ToDoModel>
}