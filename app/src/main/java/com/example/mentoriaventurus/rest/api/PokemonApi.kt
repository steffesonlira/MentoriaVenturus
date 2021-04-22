/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.rest.api

import com.example.mentoriaventurus.rest.responses.PokeAPIResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {

    @GET("/api/v2/pokemon")
    fun fetchPokemons(): Call<PokeAPIResponse>

    @GET("/api/v2/ability")
    fun fetchAbities(): Call<PokeAPIResponse>

}