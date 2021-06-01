package com.jorfald.friender.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.jorfald.friender.FrienderApplication
import com.jorfald.friender.MainActivity
import com.jorfald.friender.R
import com.jorfald.friender.Utils
import com.jorfald.friender.database.PersonObject
import com.jorfald.friender.repositories.FriendRepository
import com.jorfald.friender.viewmodels.PersonViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import okhttp3.internal.Util
import java.util.*

class MainFragment: Fragment() {

    private lateinit var loader:ProgressBar

    private lateinit var viewModel:PersonViewModel

    private lateinit var queue: RequestQueue

    private lateinit var ageTextView:TextView
    private lateinit var nameTextView: TextView
    private lateinit var genderIcon:ImageView
    private lateinit var employmentTextView: TextView
    private lateinit var placeTextView:TextView
    private lateinit var profilePicture:ImageView

    private lateinit var friendsButton: Button
    private lateinit var checkButton:ImageView
    private lateinit var crossButton:ImageView

    private val friendRepo:FriendRepository = FriendRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        queue = Volley.newRequestQueue(context)

        val root = inflater.inflate(R.layout.fragment_main, container, false)

        viewModel = ViewModelProvider(this).get(PersonViewModel::class.java)

        crossButton = root.cross_button
        friendsButton = root.my_friends_button

        loader = root.loader

        ageTextView = root.age_text
        nameTextView = root.name_text
        genderIcon = root.gender_icon
        employmentTextView = root.employment_text
        placeTextView = root.place_text
        profilePicture = root.profile_image

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loader.visibility = View.VISIBLE
        setClickListeners()
        bindObservers()
        viewModel.updatePerson(queue)

    }

    private fun setClickListeners(){
        friendsButton.setOnClickListener {
            (activity as MainActivity).navigate(R.id.navigation_friends)
        }

        crossButton.setOnClickListener{
            getNewPerson()
        }
    }

    private fun getNewPerson(){
        loader.visibility = View.VISIBLE
        viewModel.updatePerson(queue)
    }

    private fun addToFriends(){

    }


    private fun bindObservers(){
        viewModel.randomPerson.observe(viewLifecycleOwner, {
            activity?.runOnUiThread{
                fillInformationAboutPerson(it)
            }
        })
    }

    @SuppressLint("ResourceAsColor")
    private fun fillInformationAboutPerson(person:PersonObject){
        val applicationContext = FrienderApplication.application.applicationContext

        ageTextView.text = Utils.getAge(Calendar.getInstance().get(Calendar.YEAR), person.date_of_birth)
        nameTextView.text = Utils.getFullName(person.first_name,person.last_name)
        genderIcon.setImageDrawable(Utils.getGenderIcon(applicationContext,person.gender))
        if(Utils.isMale(person.gender)) ageTextView.setTextColor(R.color.blue)
        else ageTextView.setTextColor(R.color.pink)
        employmentTextView.text = Utils.getEmploymentText(applicationContext,person.employment)
        placeTextView.text = Utils.getPlaceText(person.address)

        Picasso.get().load(Utils.getProfilePictureUrl(person.gender)).into(profilePicture)
        loader.visibility = View.GONE

    }

}