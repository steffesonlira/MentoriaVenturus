package com.example.mentoriaventurus.features.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import androidx.paging.rxjava2.flowable
import com.example.mentoriaventurus.domain.models.Result
import com.example.mentoriaventurus.domain.repositories.PokemonRepository
import com.example.mentoriaventurus.features.pokemon.pokemon.paging.pokemon.PokemonDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    @ExperimentalCoroutinesApi
    fun fetchPokemons(): Flowable<PagingData<Result>> =
        Pager(config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = { PokemonDataSource(pokemonRepository) }
        ).flowable.cachedIn(viewModelScope)
}