package com.example.mentoriaventurus.data.persistence.entities.pokemonabilities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mentoriaventurus.data.persistence.entities.PokemonEntity

data class PokemonAbilityAndPokemonItem(

    @Embedded
    val pokemonAbilityEntity: PokemonAbilityEntity,

    @Relation(
        parentColumn = "pokemon_id",
        entityColumn = "pokemon_id",
        entity = PokemonEntity::class
    )
    val pokemon: PokemonEntity
)
