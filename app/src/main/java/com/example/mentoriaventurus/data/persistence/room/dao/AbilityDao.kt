package com.example.mentoriaventurus.data.persistence.room.dao

import androidx.room.*
import com.example.mentoriaventurus.data.persistence.entities.abilities.AbilityAndPokemonAbilityItem
import com.example.mentoriaventurus.data.persistence.entities.abilities.AbilityEntity

interface AbilityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(abilityEntity: AbilityEntity)

    @Query("SELECT * FROM abilities")
    fun getAllAbilities(): List<AbilityEntity>

    @Query("SELECT * FROM abilities WHERE name = :name")
    fun getAbilityByName(name: String): AbilityEntity

//    @Query("SELECT * FROM abilities WHERE name = :name")
//    fun getAllPokemonsByAbility(name: String): List<AbilityAndPokemonAbilityItem>

    @Query("SELECT pa.id, p.* FROM pokemon_abilities AS pa " +
            "INNER JOIN abilities AS a pa.ability_id = a.ability_id " +
            "INNER JOIN pokemons AS p ON pa.pokemon_id = p.pokemon_id " +
            "WHERE a.name = :name")
    fun getAllPokemonsByAbility(name: String): List<AbilityAndPokemonAbilityItem>

    @Delete
    fun delete(abilityEntity: AbilityEntity)
}
