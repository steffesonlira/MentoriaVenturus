/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.rest

import com.example.mentoriaventurus.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object BuildRetrofit {

    private const val TIMEOUT = 30L // 30 seconds

//    operator fun invoke(apiURL: String, httpClient: OkHttpClient): Retrofit =
//        with(Retrofit.Builder()) {
//            baseUrl(apiURL)
//            client(httpClient)
//            addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Para usar RXJava
//            addConverterFactory(ScalarsConverterFactory.create()) // Para pegar String do response
//            addConverterFactory(GsonConverterFactory.create()) // Para converter Json
//            build()
//        }

    operator fun invoke(): Retrofit {
        val builder = OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)

        val httpClient = builder.build()

        return with(Retrofit.Builder()) {
            baseUrl(BuildConfig.API_BASE_URL)
            client(httpClient)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Para usar RXJava
            addConverterFactory(ScalarsConverterFactory.create()) // Para pegar String do response
            addConverterFactory(GsonConverterFactory.create()) // Para converter Json
            build()
        }
    }
}