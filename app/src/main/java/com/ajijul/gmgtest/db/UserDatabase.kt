package com.ajijul.gmgtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ajijul.gmgtest.network.models.ResultX

@Database(entities = [ResultX::class], version = 2)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase(){

    abstract fun getUserDao(): UserDAO
}