/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.rest.di

import com.example.mentoriaventurus.data.rest.BuildRetrofit
import com.example.mentoriaventurus.data.rest.api.AbilityApi
import com.example.mentoriaventurus.data.rest.api.PokemonApi
import com.example.mentoriaventurus.data.rest.infrastructures.AbilityInfrastructure
import com.example.mentoriaventurus.data.rest.infrastructures.PokemonInfrastructure
import com.example.mentoriaventurus.data.rest.mappers.AbilityMapper
import com.example.mentoriaventurus.data.rest.mappers.PokemonMapper
import com.example.mentoriaventurus.data.rest.mappers.ResultMapper
import com.example.mentoriaventurus.data.rest.models.ApiUrl
import com.example.mentoriaventurus.domain.services.AbilityService
import com.example.mentoriaventurus.domain.services.PokemonService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RestModule {

    @Binds
    @Singleton
    abstract fun bindAbilityService(infrastructure: AbilityInfrastructure): AbilityService

    @Binds
    @Singleton
    abstract fun bindPokemonService(infrastructure: PokemonInfrastructure): PokemonService

    companion object {
        private const val TIMEOUT = 30L // 30 seconds
        private const val FOLDER_CACHE_NAME = "http-cache"
        private const val CACHE_SIZE = 10 * 1024 * 1024 // 10 MB

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)

            return builder.build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(client: OkHttpClient, apiUrl: ApiUrl): Retrofit =
            BuildRetrofit(apiURL = apiUrl, httpClient = client)

        @Provides
        @Singleton
        fun provideAbilityApi(retrofit: Retrofit): AbilityApi =
            retrofit.create(AbilityApi::class.java)

        @Provides
        @Singleton
        fun providePokemonApi(retrofit: Retrofit): PokemonApi =
            retrofit.create(PokemonApi::class.java)

        @Provides
        @Singleton
        fun provideAbilityMapper(resultMapper: ResultMapper): AbilityMapper =
            AbilityMapper(resultMapper)

        @Provides
        @Singleton
        fun providePokemonMapper(resultMapper: ResultMapper): PokemonMapper =
            PokemonMapper(resultMapper)

        @Provides
        @Singleton
        fun provideResultMapper(): ResultMapper = ResultMapper()
    }
}