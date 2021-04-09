package com.example.mentoriaventurus.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "pokemons"
)
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "url") var url: String
)