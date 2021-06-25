package com.example.mentoriaventurus.data.persistence.room.dao

import androidx.room.*
import com.example.mentoriaventurus.data.persistence.entities.abilities.AbilityAndPokemonAbilityItem
import com.example.mentoriaventurus.data.persistence.entities.abilities.AbilityEntity

interface AbilityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: AbilityEntity)

    @Query("SELECT * FROM abilities")
    fun loadAll(): List<AbilityEntity>

    @Query("SELECT * FROM abilities WHERE name = :name")
    fun loadByName(name: String): AbilityEntity

//    @Query("SELECT * FROM abilities WHERE name = :name")
//    fun getAllPokemonsByAbility(name: String): List<AbilityAndPokemonAbilityItem>

    @Delete
    fun delete(entity: AbilityEntity)
}
