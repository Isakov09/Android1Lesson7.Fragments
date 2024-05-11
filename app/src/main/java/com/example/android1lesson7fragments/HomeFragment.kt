package com.example.android1lesson7fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android1lesson7fragments.databinding.FragmentHomeBinding
import com.example.android1lesson7fragments.databinding.FragmentSecondBinding

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goFirstFragment()
        goSecondFragment()
        goThirdFragment()

    }

    private fun goFirstFragment() {
        binding.catButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment())
                .addToBackStack(FIRST_KEY)
                .commit()
        }
    }

    private fun goSecondFragment() {
        binding.dogButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment())
                .addToBackStack(SECOND_KEY)
                .commit()
        }
    }

    private fun goThirdFragment() {
        binding.movieButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, ThirdFragment())
                .addToBackStack(THIRD_KEY)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object{
        const val FIRST_KEY = "first"
        const val SECOND_KEY = "second"
        const val THIRD_KEY = "third"
    }
}