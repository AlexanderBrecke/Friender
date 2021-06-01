package com.jorfald.friender.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

val gson = Gson()

@Entity(tableName = "friend_table")
data class PersonObject(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val first_name: String,
    val last_name: String,
    val email: String,
    val gender: String,
    val date_of_birth: String,

    @Embedded
    val employment: ObjectClass2?,

    @Embedded
    val address: ObjectClass3,

    val imageUrl: String?
) {
    companion object{
        public fun fromJson(jsonString:String): PersonObject = gson.fromJson(jsonString, PersonObject::class.java)
    }
}

data class ObjectClass2(
    val title: String,
    val key_skill: String
)

data class ObjectClass3(
    val city: String,
    val country: String
)