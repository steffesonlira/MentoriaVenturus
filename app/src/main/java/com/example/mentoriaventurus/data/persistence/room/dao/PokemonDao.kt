package com.example.mentoriaventurus.data.persistence.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

import com.example.mentoriaventurus.data.persistence.entities.PokemonEntity


interface PokemonDao {
    @Insert(onConflict = REPLACE)
    fun insert(pokemonEntity: PokemonEntity)

    @Query("SELECT * FROM pokemons")
    fun getAllPokemons(): List<PokemonEntity>

    @Query("SELECT * FROM pokemons WHERE name = :name")
    fun getPokemonByName(name: String): PokemonEntity

    @Delete
    fun delete(pokemonEntity: PokemonEntity)
}