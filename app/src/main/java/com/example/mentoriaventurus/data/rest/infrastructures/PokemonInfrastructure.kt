/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.rest.infrastructures

import com.example.mentoriaventurus.data.rest.api.PokemonApi
import com.example.mentoriaventurus.data.rest.mappers.PokemonMapper
import com.example.mentoriaventurus.domain.models.Pokemon
import com.example.mentoriaventurus.domain.services.PokemonService
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class PokemonInfrastructure @Inject constructor(
    private val service: PokemonApi,
    private val mapper: PokemonMapper,
    private val targetScheduler: Scheduler
) : PokemonService {

    override fun fetchPokemons(offset: Int): Single<Pokemon> =
        service.fetchPokemons(offset)
            .subscribeOn(targetScheduler)
            .map { mapper.fromResponse(it) }
}