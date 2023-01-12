package com.example.kakalogger.db.main

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Log::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun logDao(): LogDao
}