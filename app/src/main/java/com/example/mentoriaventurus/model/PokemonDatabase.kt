package com.example.mentoriaventurus.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.mentoriaventurus.dao.PokemonDao
import com.example.mentoriaventurus.entity.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun createPokemonDAO(): PokemonDao

    companion object {
        private var pokemonDatabase: PokemonDatabase? = null
        fun getInstance(context: Context): PokemonDatabase? {
            if (pokemonDatabase == null) {
                pokemonDatabase = databaseBuilder(
                    context.getApplicationContext(),
                    PokemonDatabase::class.java, "pokemon_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return pokemonDatabase
        }

    }
}
