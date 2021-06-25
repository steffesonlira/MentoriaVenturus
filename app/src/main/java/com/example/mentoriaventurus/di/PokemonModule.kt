/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.di

import com.example.mentoriaventurus.data.rest.models.ApiUrl
import com.example.mentoriaventurus.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PokemonModule {

    @Provides
    @Singleton
    fun provideApiURL(): ApiUrl = ApiUrl(BuildConfig.API_BASE_URL)

    @Provides
    @Singleton
    fun provideIoScheduler(): Scheduler = Schedulers.io()
}