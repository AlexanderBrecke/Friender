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

        val navController = findNavController(R.id.nav_host_fragment)
//        val navController = findNavController(R.id.nav_host_fragment)
//        var id = 1L
//        var email = "abc@test.no"
//        val variable2 = "https://random-data-api.com/api/users/random_user"
//        var gender = "female"
//        var image = "https://www.wkbn.com/wp-content/uploads/sites/48/2021/05/e175d19a8a63442f8d5a3159123c0f23-2-3-1.jpg?w=876"
//        findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
//        val stringRequest = StringRequest(
//            Request.Method.GET, variable2,
//            { response ->
//                id = Gson().fromJson(response, ObjectClass::class.java).id
//                email = Gson().fromJson(response, ObjectClass::class.java).email
//                findViewById<TextView>(R.id.age_text).text = Utils.getAge(
//                    Calendar.getInstance().get(Calendar.YEAR),
//                    Gson().fromJson(response, ObjectClass::class.java).date_of_birth
//                )
//                findViewById<TextView>(R.id.name_text).text =
//                    Utils.getFullName(
//                        Gson().fromJson(response, ObjectClass::class.java).first_name,
//                        Gson().fromJson(response, ObjectClass::class.java).last_name,
//                    )
//                findViewById<ImageView>(R.id.gender_icon).setImageDrawable(
//                    Utils.getGenderIcon(
//                        this,
//                        Gson().fromJson(response, ObjectClass::class.java).gender
//                    )
//                )
//                findViewById<TextView>(R.id.age_text).setTextColor(
//                    if (Utils.isMale(Gson().fromJson(response, ObjectClass::class.java).gender)) {
//                        ContextCompat.getColor(this, R.color.blue)
//                    } else {
//                        ContextCompat.getColor(this, R.color.pink)
//                    }
//                )
//                findViewById<TextView>(R.id.employment_text).text =
//                    Utils.getEmploymentText(
//                        this,
//                        Gson().fromJson(response, ObjectClass::class.java).employment
//                    )
//                findViewById<TextView>(R.id.place_text).text =
//                    Utils.getPlaceText(
//                        Gson().fromJson(response, ObjectClass::class.java).address
//                    )
//                Picasso.get().load(
//                    Utils.getProfilePictureUrl(
//                        Gson().fromJson(response, ObjectClass::class.java).gender
//                    )
//                ).into(findViewById<ImageView>(R.id.profile_image))
//                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//            },
//            {
//                Log.e("ERROR", "ERROR")
//                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//            })
//        Volley.newRequestQueue(this).add(
//            stringRequest
//        )
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
//            val variable3 = "https://random-data-api.com/api/users/random_user"
//            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
//            val stringRequest2 = StringRequest(Request.Method.GET, variable3,
//                { response ->
//                    findViewById<TextView>(R.id.age_text).text = Utils.getAge(
//                        Calendar.getInstance().get(Calendar.YEAR),
//                        Gson().fromJson(response, ObjectClass::class.java).date_of_birth
//                    )
//                    findViewById<TextView>(R.id.name_text).text =
//                        Utils.getFullName(
//                            Gson().fromJson(response, ObjectClass::class.java).first_name,
//                            Gson().fromJson(response, ObjectClass::class.java).last_name,
//                        )
//                    findViewById<TextView>(R.id.age_text).setTextColor(
//                        if (Utils.isMale(Gson().fromJson(response, ObjectClass::class.java).gender)) {
//                            ContextCompat.getColor(this, R.color.blue)
//                        } else {
//                            ContextCompat.getColor(this, R.color.pink)
//                        }
//                    )
//                    findViewById<ImageView>(R.id.gender_icon).setImageDrawable(
//                        Utils.getGenderIcon(
//                            this,
//                            Gson().fromJson(response, ObjectClass::class.java).gender
//                        )
//                    )
//                    findViewById<TextView>(R.id.employment_text).text =
//                        Utils.getEmploymentText(
//                            this,
//                            Gson().fromJson(response, ObjectClass::class.java).employment
//                        )
//                    findViewById<TextView>(R.id.place_text).text =
//                        Utils.getPlaceText(
//                            Gson().fromJson(response, ObjectClass::class.java).address
//                        )
//                    Picasso.get().load(
//                        Utils.getProfilePictureUrl(
//                            Gson().fromJson(response, ObjectClass::class.java).gender
//                        )
//                    ).into(findViewById<ImageView>(R.id.profile_image))
//                    findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//                },
//                {
//                    Log.e("ERROR", "ERROR")
//                    findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//                })
//            Volley.newRequestQueue(this).add(
//                stringRequest2
//            )
//        }
//        findViewById<ImageView>(R.id.cross_button).setOnClickListener {
//            val variable4 = "https://random-data-api.com/api/users/random_user"
//            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
//            val stringRequest3 = StringRequest(Request.Method.GET, variable4,
//                { response ->
//                    findViewById<TextView>(R.id.age_text).text = Utils.getAge(
//                        Calendar.getInstance().get(Calendar.YEAR),
//                        Gson().fromJson(response, ObjectClass::class.java).date_of_birth
//                    )
//                    findViewById<TextView>(R.id.name_text).text =
//                        Utils.getFullName(
//                            Gson().fromJson(response, ObjectClass::class.java).first_name,
//                            Gson().fromJson(response, ObjectClass::class.java).last_name,
//                        )
//                    findViewById<TextView>(R.id.age_text).setTextColor(
//                        if (Utils.isMale(Gson().fromJson(response, ObjectClass::class.java).gender)) {
//                            ContextCompat.getColor(this, R.color.blue)
//                        } else {
//                            ContextCompat.getColor(this, R.color.pink)
//                        }
//                    )
//                    findViewById<ImageView>(R.id.gender_icon).setImageDrawable(
//                        Utils.getGenderIcon(
//                            this,
//                            Gson().fromJson(response, ObjectClass::class.java).gender
//                        )
//                    )
//                    findViewById<TextView>(R.id.employment_text).text =
//                        Utils.getEmploymentText(
//                            this,
//                            Gson().fromJson(response, ObjectClass::class.java).employment
//                        )
//                    findViewById<TextView>(R.id.place_text).text =
//                        Utils.getPlaceText(
//                            Gson().fromJson(response, ObjectClass::class.java).address
//                        )
//                    Picasso.get().load(
//                        Utils.getProfilePictureUrl(
//                            Gson().fromJson(response, ObjectClass::class.java).gender
//                        )
//                    ).into(findViewById<ImageView>(R.id.profile_image))
//                    findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//                },
//                {
//                    Log.e("ERROR", "ERROR")
//                    findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//                })
//            Volley.newRequestQueue(this).add(
//                stringRequest3
//            )
//        }
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

    override fun onBackPressed() {
//        if (findViewById<Button>(R.id.fragment_friends_list).visibility == View.VISIBLE) {
//            findViewById<Button>(R.id.fragment_friends_list).visibility = View.GONE
//        } else {
//        }
        super.onBackPressed()
    }

    fun navigate(id:Int){
        findNavController(R.id.nav_host_fragment).navigate(id)
    }
}