package com.jorfald.friender.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.jorfald.friender.FrienderApplication
import com.jorfald.friender.Utils
import com.jorfald.friender.database.PersonObject
import com.jorfald.friender.repositories.FriendRepository

class PersonViewModel:ViewModel() {

    private val friendRepo = FriendRepository()
    private val _randomPersonLiveData = MutableLiveData<PersonObject>()
    val randomPerson = _randomPersonLiveData

    private fun getRandomPersonFromApi(errorCallBack: () -> Unit){
        friendRepo.getRandomUserObject {
            it?.let {
                if(_randomPersonLiveData.value != it) _randomPersonLiveData.postValue(it)
            }?: run {
                errorCallBack()
            }
        }
    }

    fun getRandomPerson(){
        getRandomPersonFromApi {
            Toast.makeText(FrienderApplication.application.applicationContext,"Something went wrong, could not fetch new person",Toast.LENGTH_SHORT).show()
        }
    }

    fun addPersonToDatabase(){
        Utils.runFunctionAsCoroutine {
            _randomPersonLiveData.value?.let {
                friendRepo.addFriend(it)
            }
        }
    }

}