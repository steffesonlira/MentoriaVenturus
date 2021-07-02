/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.features.pokemon.pokemon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mentoriaventurus.databinding.ItemPokemonBinding
import com.example.mentoriaventurus.domain.models.Result
import com.example.mentoriaventurus.features.pokemon.pokemon.paging.pokemon.PokemonComparator

class PokemonAdapter :
    PagingDataAdapter<Result, PokemonAdapter.PokemonViewHolder>(PokemonComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val itemBinding: ItemPokemonBinding = ItemPokemonBinding.inflate(inflate)

        return PokemonViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon: Result = getItem(position)!!
        holder.bind(pokemon)
    }

    inner class PokemonViewHolder(
        private val itemBinding: ItemPokemonBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(row: Result) {
            addLoadStateListener { loadStates ->
                itemBinding.pgLoading.visibility =
                    if (loadStates.refresh is LoadState.Loading) View.VISIBLE else View.GONE
            }
            itemBinding.run {
                textName.text = row.name
            }
        }
    }

}