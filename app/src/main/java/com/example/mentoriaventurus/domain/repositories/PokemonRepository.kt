/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.domain.repositories

import com.example.mentoriaventurus.domain.models.Pokemon
import com.example.mentoriaventurus.domain.services.PokemonService
import io.reactivex.Single

class PokemonRepository(
    private val service: PokemonService
) {

    fun fetchPokemons(offset: Int): Single<Pokemon> = service.fetchPokemons(offset)
}