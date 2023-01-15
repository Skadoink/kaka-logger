package com.example.kakalogger.db.main

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.runBlocking

@Database(entities = [Log::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun logDao() : LogDao
}