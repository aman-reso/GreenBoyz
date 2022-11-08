package com.example.tripgo.resources

import android.content.Context
import androidx.collection.LruCache
import com.example.tripgo.MyApplication
import com.example.tripgo.R
import javax.inject.Singleton

@Singleton
open class ResString {
    private var lruCache: LruCache<String, String> = LruCache(10)

    private fun loadString() {
        lruCache.evictAll()
    }

    open fun getStringKey(key: String): String {
        return lruCache.get(key) ?: getKeyFromAndroidRes(key)
    }

    private fun getKeyFromAndroidRes(key: String): String {
        val context:Context = MyApplication.getApplication()
        return context.resources.getString(getResIdUsingString(key))
    }

    private fun getResIdUsingString(key: String): Int {
        return when (key) {
            "Name" -> {
                R.string.app_name
            }
            else->{
                R.string.app_name
            }
        }
    }
}
