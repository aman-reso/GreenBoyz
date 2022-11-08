package com.example.tripgo.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tripgo.data.UserModel

@Database(
    entities = [
        UserModel::class,
    ],
    version = 1
)
abstract class GreenBoyzDatabase : RoomDatabase() {
    companion object{
        const val DB_NAME="green_boyz_db"
    }
    abstract fun userDao(): UserDao
}