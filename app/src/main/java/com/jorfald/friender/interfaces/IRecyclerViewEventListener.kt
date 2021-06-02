package com.jorfald.friender.interfaces

import com.jorfald.friender.database.PersonObject

interface IRecyclerViewEventListener {
    fun onCrossClickListener(person:PersonObject)
}