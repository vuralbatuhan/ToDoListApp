package com.example.todolistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetaySayfaViewModel @Inject constructor (var trepo: ToDoRepository) :ViewModel() {

    fun guncelle(todo_id:Int,todo_name:String){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.guncelle(todo_id,todo_name)
        }
    }
}