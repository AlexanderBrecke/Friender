package com.jorfald.friender

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {


    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
//        var image = "https://www.wkbn.com/wp-content/uploads/sites/48/2021/05/e175d19a8a63442f8d5a3159123c0f23-2-3-1.jpg?w=876"

    }

    fun navigate(id:Int){
        navController.navigate(id)
    }
}