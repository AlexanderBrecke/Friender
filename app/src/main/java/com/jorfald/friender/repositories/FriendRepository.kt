package com.jorfald.friender.repositories

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.jorfald.friender.FrienderApplication
import com.jorfald.friender.Utils
import com.jorfald.friender.database.AppDatabase
import com.jorfald.friender.database.PersonObject

class FriendRepository {

    private val friendDao = AppDatabase.getDatabase(FrienderApplication.application.applicationContext).friendDao()

    fun addFriend(friendToAdd:PersonObject){
        friendDao.addFriend(friendToAdd)
    }

    fun getAllFriends():List<PersonObject>{
        return friendDao.getAllFriends()
    }

    fun deleteFriendWithId(id:Long){
        friendDao.deleteFriendWithId(id)
    }

    fun deleteFriend(friendToDelete:PersonObject){
        friendDao.deleteFriend(friendToDelete)
    }



}