package com.jorfald.friender.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jorfald.friender.R
import com.jorfald.friender.adapters.FriendsAdapter
import com.jorfald.friender.database.PersonObject
import com.jorfald.friender.interfaces.IRecyclerViewEventListener
import com.jorfald.friender.viewmodels.PersonViewModel

class FriendsFragment: Fragment(), IRecyclerViewEventListener {

    private lateinit var viewModel:PersonViewModel

    private lateinit var recyclerView:RecyclerView
    private lateinit var recyclerAdapter:FriendsAdapter
    private lateinit var recyclerLayoutManager:RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_friends, container, false)

        recyclerView = root.findViewById(R.id.friends_recycler)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecyclerView()
        bindObservers()
        viewModel.getAllFriends()

    }

    private fun bindObservers(){
        viewModel.friendsList.observe(viewLifecycleOwner, {
            activity?.runOnUiThread{
                recyclerAdapter.updateData(it)
            }
        })
    }

    private fun initializeRecyclerView(){
        recyclerLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = recyclerLayoutManager

        recyclerAdapter = FriendsAdapter(listOf(),this)
        recyclerView.adapter = recyclerAdapter
    }

    override fun onCrossClickListener(person: PersonObject) {
        viewModel.removeFriend(person)
    }

}