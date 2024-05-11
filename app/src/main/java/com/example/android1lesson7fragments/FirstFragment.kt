package com.example.android1lesson7fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android1lesson7fragments.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private val adapter = AnimalsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        modelAnimals()
    }

    private fun initialize() {
        binding.rvFirst.adapter = adapter
        adapter.setAppList(modelAnimals())
    }

    private fun modelAnimals() = listOf(
        AnimalsModel(R.drawable.cat1, getString(R.string.fact1)),
         AnimalsModel(R.drawable.cat2, getString(R.string.fact2)),
         AnimalsModel(R.drawable.cat3, getString(R.string.fact3)),
         AnimalsModel(R.drawable.cat4, getString(R.string.fact4)),
         AnimalsModel(R.drawable.cat5, getString(R.string.fact5)),

    )

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}