package com.qantas.test.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CityConverter {
    @TypeConverter
    fun fromMediaToJson(stat: City): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun fromJsonToMedia(jsonImages: String): City {
        val type = object : TypeToken<City>() {}.type
        return Gson().fromJson(jsonImages, type)
    }
}