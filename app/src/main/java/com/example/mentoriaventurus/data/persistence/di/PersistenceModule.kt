/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.persistence.di

import android.app.Application
import androidx.room.Room
import com.example.mentoriaventurus.data.persistence.room.PokemonRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    @Singleton
    fun providePokemonRoomDatabase(
        app: Application
    ): PokemonRoomDatabase = Room.databaseBuilder(
        app,
        PokemonRoomDatabase::class.java,
        PokemonRoomDatabase.DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
}