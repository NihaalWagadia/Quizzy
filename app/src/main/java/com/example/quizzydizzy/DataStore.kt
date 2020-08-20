package com.example.quizzydizzy

import android.content.Context

object DataStore {
    fun getProperty(
        context: Context,
        fileName: String,
        propertyName: String,
        defaultValue: String
    ): String {
        return getSharedPreferences(context, fileName).getString(propertyName, defaultValue)?: defaultValue


    }
    fun getProperty(
        context: Context,
        fileName: String,
        propertyName: String,
        defaultValue: Int = 0
    ): Int {
        return getSharedPreferences(context, fileName).getInt(propertyName, defaultValue)


    }

    fun getSharedPreferences(context: Context, fileName: String) = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
}