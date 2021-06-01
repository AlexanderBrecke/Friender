package com.jorfald.friender.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FriendDao {
    @Insert
    fun addFriend(item: PersonObject)

    @Query("SELECT * FROM friend_table")
    fun getAllFriends(): List<PersonObject>

    @Query("DELETE FROM friend_table WHERE id = :id")
    fun deleteFriendWithId(id: Long)

    @Delete
    fun deleteFriend(friendToDelete:PersonObject)
}