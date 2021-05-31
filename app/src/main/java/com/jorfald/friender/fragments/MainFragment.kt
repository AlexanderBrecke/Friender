package com.jorfald.friender.fragments

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.jorfald.friender.MainActivity
import com.jorfald.friender.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment: Fragment() {

    private lateinit var friendsButton: Button
    private lateinit var checkButton:ImageView
    private lateinit var crossButton:ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_main, container, false)
        friendsButton = root.my_friends_button
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
    }

    fun setClickListeners(){
        friendsButton.setOnClickListener {
            (activity as MainActivity).navigate(R.id.navigation_friends)
        }
    }

}