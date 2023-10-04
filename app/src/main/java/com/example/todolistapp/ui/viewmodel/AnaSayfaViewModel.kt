package com.example.todolistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.entity.ToDoModel
import com.example.todolistapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor (var trepo: ToDoRepository) :ViewModel() {

    var todoList = MutableLiveData<List<ToDoModel>>()

    init {
        todoYukle()
    }

    fun sil (todo_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.sil(todo_id)
            todoYukle()
        }
    }

    fun todoYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = trepo.todoYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = trepo.ara(aramaKelimesi)
        }
    }
}