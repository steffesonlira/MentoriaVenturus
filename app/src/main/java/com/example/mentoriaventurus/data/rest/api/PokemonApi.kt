/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.rest.api

import com.example.mentoriaventurus.data.rest.responses.AbilityResponse
import com.example.mentoriaventurus.data.rest.responses.PokemonResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface PokemonApi {

//    Retrofit
//    @GET("/api/v2/pokemon")
//    fun fetchPokemons(): Call<PokemonResponse>

//    RxJava
    @GET("/api/v2/pokemon")
    fun fetchPokemons(): Flowable<PokemonResponse>

//    Coroutines
    @GET("/api/v2/ability")
    suspend fun fetchAbilities(): AbilityResponse

}