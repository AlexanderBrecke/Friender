package com.jorfald.friender.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.jorfald.friender.FrienderApplication
import com.jorfald.friender.MainActivity
import com.jorfald.friender.R
import com.jorfald.friender.Utils
import com.jorfald.friender.database.PersonObject
import com.jorfald.friender.repositories.FriendRepository
import com.jorfald.friender.viewmodels.PersonViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.view.*
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        queue = Volley.newRequestQueue(context)

        val root = inflater.inflate(R.layout.fragment_main, container, false)

        viewModel = ViewModelProvider(this).get(PersonViewModel::class.java)

        checkButton = root.check_button
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
        if(viewModel.randomPerson.value == null) viewModel.getRandomPerson()

    }

    private fun setClickListeners(){
        friendsButton.setOnClickListener {
            (activity as MainActivity).navigate(R.id.navigation_friends)
        }
        enableCheckAndCrossButtons()
    }

    private fun enableCheckAndCrossButtons(){
        crossButton.setOnClickListener{
            getNewPerson()
        }
        checkButton.setOnClickListener {
            addToFriends()
        }
    }

    private fun disableCheckAndCrossButtons(){
        checkButton.setOnClickListener {}
        crossButton.setOnClickListener {}
    }

    private fun getNewPerson(){
        loader.visibility = View.VISIBLE
        viewModel.getRandomPerson()
        disableCheckAndCrossButtons()
    }

    private fun addToFriends(){
        viewModel.addPersonToDatabase()
        getNewPerson()
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

        val pictureString = Utils.getProfilePictureUrl(person.gender)
        if(person.imageUrl == null){
            person.imageUrl = pictureString
        }
        Picasso.get().load(person.imageUrl).into(profilePicture)
        loader.visibility = View.GONE
        enableCheckAndCrossButtons()

    }

}