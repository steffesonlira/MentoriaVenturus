package com.example.mentoriaventurus.domain.di

import com.example.mentoriaventurus.domain.repositories.PokemonRepository
import com.example.mentoriaventurus.domain.services.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providePokemonRepository(service: PokemonService) = PokemonRepository(service)

}