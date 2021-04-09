package com.example.mentoriaventurus.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mentoriaventurus.dao.AbilityDao
import com.example.mentoriaventurus.entity.AbilityEntity

@Database(entities = [AbilityEntity::class], version = 1)
abstract class AbilityDatabase: RoomDatabase() {
    abstract fun createAbilityDAO(): AbilityDao

    companion object {
        private var abilityDatabase: AbilityDatabase? = null
        fun getInstance(context: Context): AbilityDatabase? {
            if (abilityDatabase == null) {
                abilityDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AbilityDatabase::class.java, "ability_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return abilityDatabase
        }
    }
}