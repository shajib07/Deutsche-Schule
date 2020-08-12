package com.atahar.germanschool.db.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class KeywordConverter {

    @TypeConverter
    fun listToJson(list: List<String>) = Gson().toJson(list)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<String>::class.java).toList()
}