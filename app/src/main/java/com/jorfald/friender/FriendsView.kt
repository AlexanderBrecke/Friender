package com.jorfald.friender

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.jorfald.friender.R
import com.jorfald.friender.Utils
import com.jorfald.friender.database.ObjectClass
import com.squareup.picasso.Picasso

class FriendsView(context: Context) : FrameLayout(context) {
    private val view: View = LayoutInflater.from(context).inflate(R.layout.friends_view, this)

    fun setData(objectClass: ObjectClass) {
        view.findViewById<TextView>(R.id.friend_name_text).text =
            Utils.getFullName(objectClass.first_name, objectClass.last_name) + " (" + Utils.getAge(
                2021,
                objectClass.date_of_birth
            ) + ")"
        view.findViewById<TextView>(R.id.friend_place_text).text =
            Utils.getPlaceText(objectClass.address)
        view.findViewById<ConstraintLayout>(R.id.friend_click_wrapper).setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle("More info")
                .setMessage(
                    Utils.getEmploymentText(context, objectClass.employment) +
                            "\n${context.getString(R.string.email)}: ${objectClass.email}"
                )
                .setPositiveButton(
                    android.R.string.ok
                ) { _, _ ->
                }
                .show()
        }
        Picasso.get().load(
            objectClass.imageUrl
        ).into(view.findViewById<ImageView>(R.id.friend_profile_picture))
    }

    fun setCrossListener(click: () -> Unit) {
        view.findViewById<ImageView>(R.id.friend_cross_button).setOnClickListener {
            click()
        }
    }
}
