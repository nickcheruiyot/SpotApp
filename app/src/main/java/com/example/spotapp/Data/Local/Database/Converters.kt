package com.example.spotapp.Data.Local.Database

import androidx.room.TypeConverter
import com.example.spotapp.Domain.Model.Location
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class Converters {
    private val gson = Gson()

    // Convert Location to JSON string
    @TypeConverter
    fun fromLocation(location: Location): String {
        return gson.toJson(location)
    }

    // Convert JSON string back to Location
    @TypeConverter
    fun toLocation(locationString: String): Location {
        return gson.fromJson(locationString, Location::class.java)
    }

    // Convert List<String> to JSON string
    @TypeConverter
    fun fromStringList(list: List<String>): String {
        return gson.toJson(list)
    }

    // Convert JSON string back to List<String>
    @TypeConverter
    fun toStringList(json: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json, type)
    }
}
