/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.features.pokemon.pokemon.paging.pokemon

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.mentoriaventurus.domain.models.Pokemon
import com.example.mentoriaventurus.domain.models.Result
import com.example.mentoriaventurus.domain.repositories.PokemonRepository
import io.reactivex.Single
import io.reactivex.annotations.NonNull
import retrofit2.HttpException
import java.io.IOException

class PokemonDataSource(
    private val pokemonRepository: PokemonRepository
) : RxPagingSource<String, Result>() {

    companion object {
        private const val POKEMON_STARTING_PAGE_INDEX = 1
        private const val OFFSET_INITIAL = 0
        private const val PAGE_SIZE = 20
    }

    override fun loadSingle(params: LoadParams<String>): Single<LoadResult<String, Result>> {
//        val nextPage = params.key ?: POKEMON_STARTING_PAGE_INDEX
//        val offset: Int = if (nextPage == 1) 0 else (nextPage - 1) * PAGE_SIZE

        val url = params.key
        val offset: Int = url?.let {
            it.substringAfter("=").substringBeforeLast("&").toIntOrNull() ?: OFFSET_INITIAL
        } ?:OFFSET_INITIAL

        return pokemonRepository.fetchPokemons(offset)
            .map(this::toLoadResult)
            .onErrorReturn { e ->
                when (e) {
                    is IOException -> LoadResult.Error(e)
                    is HttpException -> LoadResult.Error(e)
                    else -> throw e
                }
            }
    }

    override fun getRefreshKey(state: PagingState<String, Result>): String? {
        return state.anchorPosition?.let { state.closestItemToPosition(it)?.name }
    }

    private fun toLoadResult(
        @NonNull response: Pokemon
    ): LoadResult<String, Result> {

        //LoadResult<Int, Result>
//        return LoadResult.Page(
//            response.results,
//            response.previous?.let { getPageNumber(it) },
//            response.next?.let { getPageNumber(url = it, isPrevious = false) },
//            PAGE_SIZE,
//            PAGE_SIZE
//        )

        return LoadResult.Page(
            data = response.results,
            prevKey = response.previous,
            nextKey = response.next
        )
    }

    private fun getPageNumber(url: String, isPrevious: Boolean = true): Int {
        val offset = url.substringBeforeLast("&").substringAfterLast("=").toInt()
        val limit = url.substringAfterLast("=").toInt()
        val calc = limit / offset

        return if (isPrevious) calc - 1 else calc + 1
    }
}