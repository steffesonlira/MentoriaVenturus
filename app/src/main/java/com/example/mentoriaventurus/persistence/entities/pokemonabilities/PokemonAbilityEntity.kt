package com.example.mentoriaventurus.persistence.entities.pokemonabilities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon_abilities",
    indices = [Index(value = ["pokemon_id", "ability_id"], unique = true)]
)
data class PokemonAbilityEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "pokemon_ability_id") var id: Long,
    @ColumnInfo(name = "ability_id") var abilityId: Long,
    @ColumnInfo(name = "pokemon_id") var pokemonId: Long
)