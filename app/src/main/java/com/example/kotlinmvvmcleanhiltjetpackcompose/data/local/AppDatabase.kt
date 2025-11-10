package com.example.kotlinmvvmcleanhiltjetpackcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import data.local.dao.UserDao
import data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
