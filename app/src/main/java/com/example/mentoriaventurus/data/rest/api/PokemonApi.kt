/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.rest.api

import com.example.mentoriaventurus.data.rest.responses.PokemonResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

//    Retrofit
//    @GET("/api/v2/pokemon")
//    fun fetchPokemons(): Call<PokemonResponse>

    //    RxJava
    @GET("/api/v2/pokemon")
    fun fetchPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Single<PokemonResponse>
}