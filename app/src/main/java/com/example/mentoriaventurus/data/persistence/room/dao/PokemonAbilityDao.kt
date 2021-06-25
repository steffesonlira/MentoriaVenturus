package com.example.mentoriaventurus.data.persistence.room.dao

import androidx.room.*
import com.example.mentoriaventurus.data.persistence.entities.abilities.AbilityAndPokemonAbilityItem
import com.example.mentoriaventurus.data.persistence.entities.abilities.AbilityEntity
import com.example.mentoriaventurus.data.persistence.entities.pokemonabilities.PokemonAbilityEntity

interface PokemonAbilityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: PokemonAbilityEntity)

    @Delete
    fun delete(entity: AbilityEntity)
}
