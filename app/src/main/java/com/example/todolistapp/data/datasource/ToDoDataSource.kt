package com.example.todolistapp.data.datasource

import android.util.Log
import com.example.todolistapp.data.entity.ToDoModel
import com.example.todolistapp.room.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdao : ToDoDAO) {
    suspend fun kaydet(todo_name:String){
        val yeniToDo = ToDoModel(0,todo_name)
        tdao.kaydet(yeniToDo)
    }

    suspend fun guncelle(todo_id:Int,todo_name: String){
        val guncelleToDo = ToDoModel(todo_id,todo_name)
        tdao.guncelle(guncelleToDo)
    }

    suspend fun sil(todo_id:Int){
        val silToDo = ToDoModel(todo_id,"")
        tdao.sil(silToDo)
    }

    suspend fun todoYukle() : List<ToDoModel> = withContext(Dispatchers.IO){
        return@withContext tdao.todoYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<ToDoModel> = withContext(Dispatchers.IO){
        return@withContext tdao.ara(aramaKelimesi)
    }
}