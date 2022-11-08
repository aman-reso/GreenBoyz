package com.example.tripgo.storage.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlin.reflect.KClass

class DataStoreWrapper(var context: Context)  {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    init {
        intPreferencesKey("")
    }

}

interface DataStoreImpl {
    suspend fun <T>saveDataIntoValues(key: String, value: Any)
    suspend fun <T> retrieveData(key: String): Any
}