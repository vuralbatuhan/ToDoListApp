package com.example.todolistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentKayitSayfaBinding
import com.example.todolistapp.ui.viewmodel.KayitSayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitSayfaFragment : Fragment() {
    private lateinit var binding: FragmentKayitSayfaBinding
    private lateinit var viewModel: KayitSayfaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitSayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKayitSayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonKaydet.setOnClickListener {
            val todo_name = binding.todoText.text.toString()
            kaydet(todo_name)
        }

    }

    fun kaydet(todo_name:String){
        viewModel.kaydet(todo_name)
    }

}