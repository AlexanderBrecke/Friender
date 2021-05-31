package com.jorfald.friender.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorfald.friender.FriendsView
import com.jorfald.friender.database.ObjectClass

class FriendsAdapter(
    var all: List<ObjectClass>,
    val crossClicked: ((ObjectClass) -> Unit)? = null
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
