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

@Database(
    entities = [

    ],
    version = 1,
    exportSchema = false
)
abstract class MentoriaVenturusRoomDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "mentoriaventurus.db"
    }

//    abstract fun deviceDao(): DeviceDao

}