package com.example.mentoriaventurus.persistence.entities.abilities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mentoriaventurus.persistence.entities.PokemonEntity
import com.example.mentoriaventurus.persistence.entities.pokemonabilities.PokemonAbilityAndPokemonItem
import com.example.mentoriaventurus.persistence.entities.pokemonabilities.PokemonAbilityEntity

data class AbilityAndPokemonAbilityItem(

    @Embedded
    val abilityEntity: AbilityEntity,

    @Relation(
        parentColumn = "ability_id",
        entityColumn = "ability_id",
        entity = PokemonAbilityEntity::class
    )
    val pokemonAbilities: List<PokemonAbilityAndPokemonItem>
)
