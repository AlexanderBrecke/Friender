package com.jorfald.friender.repositories

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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

    fun deleteFriend(friendToDelete:PersonObject){
        friendDao.deleteFriend(friendToDelete)
    }

    fun getRandomUserObject(callback:(PersonObject?) -> Unit){
        val url = "https://random-data-api.com/api/users/random_user"
        val queue = Volley.newRequestQueue(FrienderApplication.application.applicationContext)
        val stringRequest = StringRequest(Request.Method.GET, url, {
            response ->
            val person = PersonObject.fromJson(response)
            callback(person)
        }, {
            callback(null)
        })
        queue.add(stringRequest)
    }



}