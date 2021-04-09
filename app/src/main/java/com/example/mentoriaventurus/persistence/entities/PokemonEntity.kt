package com.example.mentoriaventurus.persistence.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemons"
)
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "pokemon_id") var id: Long,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "url") var url: String,
)