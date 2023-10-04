package com.example.todolistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentAnaSayfaBinding
import com.example.todolistapp.ui.adapter.ToDoAdapter
import com.example.todolistapp.ui.viewmodel.AnaSayfaViewModel
import com.example.todolistapp.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnaSayfaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnaSayfaViewModel by viewModels()
        viewModel = tempViewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.todoList.observe(viewLifecycleOwner){
            val toDoAdapter = ToDoAdapter(requireContext(),it,viewModel)
            binding.reyclerView.adapter = toDoAdapter
        }


        binding.fab.setOnClickListener {
            Navigation.gecis(it,R.id.anaSayfaGecisKayitSayfa)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {  // arama ikonuna basıldığında çalışır
                ara(p0)
                return true
            }

            override fun onQueryTextChange(p0: String): Boolean {  // harf girdikçe veya sildikçe çalışır
                ara(p0)
                return false
            }
        })
    }

    fun ara(aramaKelimesi: String) {
        viewModel.ara(aramaKelimesi)
    }

    override fun onResume() {
        super.onResume()
        viewModel.todoYukle()
    }

}