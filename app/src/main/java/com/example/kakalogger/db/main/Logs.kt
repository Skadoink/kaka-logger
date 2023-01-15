package com.example.kakalogger.db.main

import androidx.room.*

@Entity
data class Log(
    @PrimaryKey(true)
    @ColumnInfo(name = "bands") val bands: String?,
    @ColumnInfo(name = "start_time") val startTime: String?,
    @ColumnInfo(name = "end_time") val endTime: String?
)

