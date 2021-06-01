package com.jorfald.friender.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.jorfald.friender.FrienderApplication
import com.jorfald.friender.database.PersonObject
import com.jorfald.friender.repositories.FriendRepository

class PersonViewModel:ViewModel() {

    private val url:String = "https://random-data-api.com/api/users/random_user"
    private val friendRepo = FriendRepository()
    private val _randomPersonLiveData = MutableLiveData<PersonObject>()
    val randomPerson = _randomPersonLiveData

    private fun getRandomPerson(queue: RequestQueue, errorCallBack: () -> Unit){
        val stringRequest = StringRequest(Request.Method.GET,url, {
            response ->
            val person = PersonObject.fromJson(response)
            if (_randomPersonLiveData.value != person) _randomPersonLiveData.postValue(person)
        }, {
            errorCallBack()
        })
        queue.add(stringRequest)
    }

    fun updatePerson(queue: RequestQueue){
        getRandomPerson(queue){
            Log.d("FOO", "Something went wrong, and we could not fetch a new person. Please try again")
            Toast.makeText(FrienderApplication.application.applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }

}