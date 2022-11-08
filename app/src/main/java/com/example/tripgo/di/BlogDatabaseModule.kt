package com.example.tripgo.di

import android.content.Context
import androidx.room.Room
import com.example.tripgo.storage.db.GreenBoyzDatabase
import com.example.tripgo.storage.db.GreenBoyzDatabase.Companion.DB_NAME
import com.example.tripgo.storage.db.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BlogDatabaseModule {

    @Provides
    @Singleton
    fun provideBlogDatabase(
        @ApplicationContext context: Context
    ): GreenBoyzDatabase =
        Room.databaseBuilder(context, GreenBoyzDatabase::class.java, DB_NAME)
            .build()

    @Provides
    @Singleton
    fun provideUserDao(database: GreenBoyzDatabase): UserDao = database.userDao()

}