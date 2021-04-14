/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.persistence.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mentoriaventurus.persistence.entities.PokemonEntity
import com.example.mentoriaventurus.persistence.entities.abilities.AbilityEntity
import com.example.mentoriaventurus.persistence.entities.pokemonabilities.PokemonAbilityEntity
import com.example.mentoriaventurus.persistence.room.dao.AbilityDao
import com.example.mentoriaventurus.persistence.room.dao.PokemonAbilityDao
import com.example.mentoriaventurus.persistence.room.dao.PokemonDao

@Database(
    entities = [
        AbilityEntity::class,
        PokemonAbilityEntity::class,
        PokemonEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PokemonRoomDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "pokemon.db"
    }

    abstract fun abilityDao(): AbilityDao
    abstract fun pokemonAbilityDao(): PokemonAbilityDao
    abstract fun pokemonDao(): PokemonDao

}