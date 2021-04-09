package com.example.mentoriaventurus.persistence.room.dao

import androidx.room.*
import com.example.mentoriaventurus.persistence.entities.abilities.AbilityEntity
import com.example.mentoriaventurus.persistence.entities.pokemonabilities.PokemonAbilityEntity

interface PokemonAbilityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemonAbilityEntity: PokemonAbilityEntity)

    @Delete
    fun delete(pokemonAbilityEntity: AbilityEntity)
}
