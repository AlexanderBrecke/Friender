package com.jorfald.friender

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.jorfald.friender.adapters.FriendsAdapter
import com.jorfald.friender.database.*
import com.squareup.picasso.Picasso
import java.util.*

class MainActivity : AppCompatActivity() {

//    val friendsListId:Int = R.id.navigation_friends

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navController = findNavController(R.id.nav_host_fragment)
//        val navController = findNavController(R.id.nav_host_fragment)
//        var id = 1L
//        var email = "abc@test.no"
//        val variable2 = "https://random-data-api.com/api/users/random_user"
//        var gender = "female"
//        var image = "https://www.wkbn.com/wp-content/uploads/sites/48/2021/05/e175d19a8a63442f8d5a3159123c0f23-2-3-1.jpg?w=876"
//        findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
//
//        findViewById<ImageView>(R.id.check_button).setOnClickListener {
//            Thread {
//                AppDatabase.getDatabase(this).getDao().insert(
//                    ObjectClass(
//                        id,
//                        findViewById<TextView>(R.id.name_text).text.toString(),
//                        findViewById<TextView>(R.id.name_text).text.toString(),
//                        email,
//                        gender,
//                        "2000",
//                        ObjectClass2(
//                            findViewById<TextView>(R.id.employment_text).text.substring(
//                                0,
//                                findViewById<TextView>(R.id.employment_text).text.indexOf("\n")
//                            ),
//                            findViewById<TextView>(R.id.employment_text).text.substring(
//                                findViewById<TextView>(R.id.employment_text).text.indexOf("\n"),
//                                findViewById<TextView>(R.id.employment_text).text.length
//                            )
//                        ),
//                        ObjectClass3(
//                            findViewById<TextView>(R.id.employment_text).text.substring(0, 5),
//                            findViewById<TextView>(R.id.employment_text).text.substring(5, 10)
//                        ),
//                        image
//                    )
//                )
//            }.start()
//
//
//
//        findViewById<Button>(R.id.my_friends_button).setOnClickListener {
//            findViewById<ConstraintLayout>(R.id.fragment_friends_list).visibility = View.VISIBLE
//            var rcv = findViewById<RecyclerView>(R.id.friends_recycler)
//            rcv.layoutManager = LinearLayoutManager(this)
//
//            Thread {
//                val all = AppDatabase.getDatabase(this).getDao().getAll()
//                runOnUiThread {
//                    rcv.adapter = FriendsAdapter(
//                        all
//                    )
//                }
//            }.start()
//        }
    }

    fun navigate(id:Int){
        findNavController(R.id.nav_host_fragment).navigate(id)
    }
}