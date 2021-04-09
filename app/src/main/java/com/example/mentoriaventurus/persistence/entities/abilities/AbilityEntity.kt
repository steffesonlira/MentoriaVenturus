package com.example.mentoriaventurus.persistence.entities.abilities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "abilities"
)
data class AbilityEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ability_id") var id: Long,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "url") var url: String
)