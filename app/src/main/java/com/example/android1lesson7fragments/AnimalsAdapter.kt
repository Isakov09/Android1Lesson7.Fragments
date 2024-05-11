package com.example.android1lesson7fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android1lesson7fragments.databinding.ItemAnimalsBinding

class AnimalsAdapter: RecyclerView.Adapter<AnimalsAdapter.AestheticsViewHolder>() {

    private var _animalsList = listOf<AnimalsModel>()

    fun setAppList(animalsList: List<AnimalsModel>) {
        _animalsList = animalsList
    }

    inner class AestheticsViewHolder(private val binding: ItemAnimalsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(animalsModel: AnimalsModel) {
            binding.itImage.setImageResource(animalsModel.image)
            binding.itText.text = animalsModel.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AestheticsViewHolder {
        return AestheticsViewHolder(
            ItemAnimalsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return _animalsList.size

    }

    override fun onBindViewHolder(holder: AestheticsViewHolder, position: Int) {
        holder.onBind(_animalsList[position])
    }
}