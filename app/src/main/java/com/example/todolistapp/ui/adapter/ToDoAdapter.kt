package com.example.todolistapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.data.entity.ToDoModel
import com.example.todolistapp.databinding.CardTasarimBinding
import com.example.todolistapp.ui.fragment.AnaSayfaFragmentDirections
import com.example.todolistapp.ui.viewmodel.AnaSayfaViewModel
import com.example.todolistapp.utils.gecis
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext:Context,
                  var toDoList:List<ToDoModel>,
                  var viewModel: AnaSayfaViewModel
) : RecyclerView.Adapter<ToDoAdapter.CardTasarimHolder>() {

    inner class CardTasarimHolder(var tasarim: CardTasarimBinding) : ViewHolder(tasarim.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return CardTasarimHolder(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val todo = toDoList.get(position)
        val t = holder.tasarim
        t.textView.text = todo.toDoName


        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"Silinsin mi ?",Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                sil(todo.toDoId)
            }.show()
        }

        t.cardView.setOnClickListener {
            val gecis = AnaSayfaFragmentDirections.anaSayfaGecisDetaySayfa(todo = todo)
            Navigation.gecis(it,gecis)
        }

    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    fun sil(todo_id:Int) {
        viewModel.sil(todo_id)
    }
}