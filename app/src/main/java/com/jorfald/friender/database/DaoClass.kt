package com.jorfald.friender.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoClass {
    @Insert
    fun insert(item: ObjectClass)

    @Query("SELECT * FROM table_one")
    fun getAll(): List<ObjectClass>

    @Query("DELETE FROM table_one WHERE id = :id")
    fun delete(id: Long)
}