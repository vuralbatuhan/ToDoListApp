package com.example.todolistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitSayfaViewModel @Inject constructor (var trepo: ToDoRepository) :ViewModel() {

    fun kaydet(todo_name:String){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.kaydet(todo_name)
        }
    }
}