package com.qantas.test.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CountryConverter {
    @TypeConverter
    fun fromMediaToJson(stat: Country): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun fromJsonToMedia(jsonImages: String): Country {
        val type = object : TypeToken<Country>() {}.type
        return Gson().fromJson(jsonImages, type)
    }
}