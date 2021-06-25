package com.example.mentoriaventurus.features.pokemon.pokemon.paging.pokemon

import androidx.recyclerview.widget.DiffUtil
import com.example.mentoriaventurus.domain.models.Result

object PokemonComparator : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        // Id is unique.
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}