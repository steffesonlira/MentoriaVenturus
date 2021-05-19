/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.rest

import com.example.mentoriaventurus.data.rest.models.ApiUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object BuildRetrofit {

    operator fun invoke(apiURL: ApiUrl, httpClient: OkHttpClient): Retrofit =
        with(Retrofit.Builder()) {
            baseUrl(apiURL.baseUrl)
            client(httpClient)
            addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Para usar RXJava
            addConverterFactory(ScalarsConverterFactory.create()) // Para pegar String do response
            addConverterFactory(GsonConverterFactory.create()) // Para converter Json
            build()
        }


    //Método tradicional

//    private const val TIMEOUT = 30L // 30 seconds
//
//    val builder = OkHttpClient.Builder()
//        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
//        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
//        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
//
//    val httpClient = builder.build()
//
//    private var retrofit: Retrofit = with(Retrofit.Builder()) {
//        baseUrl(BuildConfig.API_BASE_URL)
//        client(httpClient)
//        addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Para usar RXJava
//        addConverterFactory(ScalarsConverterFactory.create()) // Para pegar String do response
//        addConverterFactory(GsonConverterFactory.create()) // Para converter Json
//        build()
//    }
//
//    fun apiCallPokemon(): PokemonApi {
//        return retrofit.create(PokemonApi::class.java)
//    }
}