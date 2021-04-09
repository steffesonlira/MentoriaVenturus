package com.example.mentoriaventurus.dao

import androidx.room.*
import com.example.mentoriaventurus.entity.AbilityEntity

interface AbilityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ability: AbilityEntity?)

    @Query("SELECT * FROM abilities")
    fun getAllDrivers(): List<AbilityEntity?>?

    @Query("SELECT * FROM abilities WHERE name = :name")
    fun getDriversByName(name: String?): List<AbilityEntity?>?

    @Update
    fun update(ability: AbilityEntity?)

    @Delete
    fun delete(ability: AbilityEntity?)
}
