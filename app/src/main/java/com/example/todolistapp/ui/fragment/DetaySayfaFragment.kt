package com.example.todolistapp.ui.fragment

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentDetaySayfaBinding
import com.example.todolistapp.ui.viewmodel.DetaySayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetaySayfaFragment : Fragment() {
    private lateinit var binding: FragmentDetaySayfaBinding
    private lateinit var viewModel: DetaySayfaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetaySayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetaySayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: DetaySayfaFragmentArgs by navArgs()
        val gelenTodo = bundle.todo
        binding.todoNameText.text = Editable.Factory.getInstance().newEditable(gelenTodo.toDoName)

        binding.buttonGuncelle.setOnClickListener {
            val todo_name = binding.todoNameText.text.toString()
            guncelle(gelenTodo.toDoId,todo_name)
        }

    }

     fun guncelle(todo_id:Int, todo_name:String){
        viewModel.guncelle(todo_id,todo_name)
    }
}