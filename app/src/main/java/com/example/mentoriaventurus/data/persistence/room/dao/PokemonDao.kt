package com.example.mentoriaventurus.data.persistence.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

import com.example.mentoriaventurus.data.persistence.entities.PokemonEntity
import com.example.mentoriaventurus.data.persistence.entities.abilities.AbilityAndPokemonAbilityItem


interface PokemonDao {
    @Insert(onConflict = REPLACE)
    fun insert(entity: PokemonEntity)

    @Query("SELECT * FROM pokemons")
    fun loadAll(): List<PokemonEntity>

    @Query("SELECT pa.id, p.* FROM pokemon_abilities AS pa " +
            "INNER JOIN abilities AS a pa.ability_id = a.ability_id " +
            "INNER JOIN pokemons AS p ON pa.pokemon_id = p.pokemon_id " +
            "WHERE a.name = :name")
    fun loadAllByAbility(name: String): List<AbilityAndPokemonAbilityItem>

    @Query("SELECT * FROM pokemons WHERE name = :name")
    fun loadByName(name: String): PokemonEntity

    @Delete
    fun delete(entity: PokemonEntity)
}