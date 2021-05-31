@file:Suppress("RedundantIf", "LiftReturnOrAssignment", "MemberVisibilityCanBePrivate")

package com.jorfald.friender

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.jorfald.friender.database.ObjectClass2
import com.jorfald.friender.database.ObjectClass3

object Utils {
    fun getAge(thisYear: Int, dateOfBirth: String): String {
        return try {
            val year = dateOfBirth.substring(0, 4).toInt()
            (thisYear - year).toString()
        } catch (e: Exception) {
            "-"
        }
    }

    fun getFullName(firstName: String, lastName: String): String {
        return "$firstName $lastName"
    }

    fun getGenderIcon(context: Context, gender: String): Drawable? {
        return if (isMale(gender)) {
            ContextCompat.getDrawable(context, R.drawable.ic_male)
        } else {
            ContextCompat.getDrawable(context, R.drawable.ic_female)
        }
    }

    fun isMale(gender: String): Boolean {
        when (gender.lowercase()) {
            "male" -> {
                return true
            }
            "female" -> {
                return false
            }
            "bigender" -> {
                return false
            }
            "genderfluid" -> {
                return true
            }
            "non-binary" -> {
                return false
            }
            "polygender" -> {
                return true
            }
            "agender" -> {
                return true
            }
            else -> {
                return false
            }
        }
    }

    fun getEmploymentText(context: Context, employment: ObjectClass2?): String {
        return if (employment == null) {
            "Hobo..."
        } else {
            "${context.getString(R.string.role)} ${employment.title}\n${context.getString(R.string.skill)} ${employment.key_skill}"
        }
    }

    fun getPlaceText(address: ObjectClass3): String {
        return "${address.city}, ${address.country}"
    }

    fun getProfilePictureUrl(gender: String): String {
        val number = (0..99).random()
        val isMale = (0..1).random()

        return "https://randomuser.me/api/portraits/${if (isMale == 0) "men" else "women"}/$number.jpg"
    }
}