package com.example.todolistapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todos")
data class ToDoModel(@NotNull @ColumnInfo(name = "todo_id") @PrimaryKey(autoGenerate = true)var toDoId:Int,
                     @NotNull @ColumnInfo(name = "todo_name")var toDoName:String) : Serializable