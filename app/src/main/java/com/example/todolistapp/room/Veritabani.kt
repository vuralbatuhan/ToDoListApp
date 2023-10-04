package com.example.todolistapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolistapp.data.entity.ToDoModel

@Database(entities = [ToDoModel::class], version = 1)
abstract class Veritabani: RoomDatabase() {

    abstract fun getToDoDao() : ToDoDAO


}