package com.jorfald.friender.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorfald.friender.FriendsView
import com.jorfald.friender.database.PersonObject
import com.jorfald.friender.interfaces.IRecyclerViewEventListener

class FriendsAdapter(
    private var dataset: List<PersonObject>,
    private val recyclerEventListener:IRecyclerViewEventListener
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
        holder.view.setData(dataset[position])
        holder.view.setCrossListener {
            recyclerEventListener.onCrossClickListener(dataset[position])
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun updateData(newData:List<PersonObject>){
        dataset = newData
        notifyDataSetChanged()
    }
}
