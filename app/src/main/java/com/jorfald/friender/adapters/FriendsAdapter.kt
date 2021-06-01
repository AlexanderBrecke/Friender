package com.jorfald.friender.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorfald.friender.FriendsView
import com.jorfald.friender.database.PersonObject

class FriendsAdapter(
    var all: List<PersonObject>,
    val crossClicked: ((PersonObject) -> Unit)? = null
) :
    RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    inner class FriendsViewHolder(val view: FriendsView) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val view = FriendsView(parent.context)

        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        return FriendsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.view.setData(all[position])
        holder.view.setCrossListener {
            //TODO: "Delete friend..."
        }
    }

    override fun getItemCount(): Int {
        return all.size
    }
}
