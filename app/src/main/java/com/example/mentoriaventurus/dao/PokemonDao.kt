package com.example.mentoriaventurus.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

import androidx.room.Update
import com.example.mentoriaventurus.entity.PokemonEntity


interface PokemonDao {
    @Insert(onConflict = REPLACE)
    fun insert(pokemon: PokemonEntity?)

    @Query("SELECT * FROM pokemons")
    fun getAllDrivers(): List<PokemonEntity?>?

    @Query("SELECT * FROM pokemons WHERE name = :name")
    fun getDriversByName(name: String?): List<PokemonEntity?>?

    @Update
    fun update(pokemon: PokemonEntity?)

    @Delete
    fun delete(pokemon: PokemonEntity?)
}