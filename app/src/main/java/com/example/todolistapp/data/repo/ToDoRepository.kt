package com.example.todolistapp.data.repo

import com.example.todolistapp.data.datasource.ToDoDataSource
import com.example.todolistapp.data.entity.ToDoModel

class ToDoRepository(var tds: ToDoDataSource) {

    suspend fun kaydet(todo_name:String) = tds.kaydet(todo_name)

    suspend fun guncelle(todo_id:Int,todo_name:String) = tds.guncelle(todo_id,todo_name)

    suspend fun sil(todo_id:Int) = tds.sil(todo_id)

    suspend fun todoYukle() : List<ToDoModel> = tds.todoYukle()

    suspend fun ara(aramaKelimesi:String) : List<ToDoModel> = tds.ara(aramaKelimesi)


}