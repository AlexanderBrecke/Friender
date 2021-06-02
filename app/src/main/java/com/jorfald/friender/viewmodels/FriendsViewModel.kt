package com.jorfald.friender.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorfald.friender.Utils
import com.jorfald.friender.database.PersonObject
import com.jorfald.friender.repositories.FriendRepository

class FriendsViewModel:ViewModel() {

    private val _friendsList = MutableLiveData<List<PersonObject>>()
    val friendsList = _friendsList
    private val friendRepo = FriendRepository()

    fun getAllFriends(){
        Utils.runFunctionAsCoroutine {
            val allFriends = friendRepo.getAllFriends()
            if(_friendsList.value != allFriends) _friendsList.postValue(allFriends)
        }
    }

    fun removeFriend(friendToRemove:PersonObject){
        Utils.runFunctionAsCoroutine {
            friendRepo.deleteFriend(friendToRemove)
        }
        getAllFriends()
    }



}