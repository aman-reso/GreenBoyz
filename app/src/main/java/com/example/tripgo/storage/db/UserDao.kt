package com.example.tripgo.storage.db

import androidx.room.Dao
import androidx.room.Insert
import com.example.tripgo.data.UserModel
@Dao
interface UserDao {
    @Insert
    suspend fun setUser(userModel: UserModel)
}