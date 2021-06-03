package com.jorfald.friender

import androidx.core.content.ContextCompat
import com.jorfald.friender.database.ObjectClass2
import com.jorfald.friender.database.ObjectClass3
import junit.framework.TestCase
import org.junit.Test


class UtilsTest : TestCase() {

    @Test
    fun testGetAge() {

        // Given
        val thisYear = 2021
        val date1 = "1990"
        // When
        val result = Utils.getAge(thisYear, date1)

        // Then
        assertTrue("31" == result)
        assertEquals("31",result)

    }

    @Test
    fun testGetFullName() {
        val firstName1 = "FirstName"
        val lastName1 = "LastName"

        val firstName2 = "First"
        val lastName2 = "Last"

        val result1 = Utils.getFullName(firstName1,lastName1)
        val result2 = Utils.getFullName(firstName2,lastName2)

        assertTrue("FirstName LastName" == result1)
        assertEquals("First Last", result2)
    }


    fun testGetGenderIcon() {
        val male = "male"
        val female = "female"

        val maleIcon = ContextCompat.getDrawable(FrienderApplication.application.applicationContext, R.drawable.ic_male)
        val femaleIcon = ContextCompat.getDrawable(FrienderApplication.application.applicationContext, R.drawable.ic_female)

        val result1 = Utils.getGenderIcon(FrienderApplication.application.applicationContext,male)
        val result2 = Utils.getGenderIcon(FrienderApplication.application.applicationContext,female)

        assertEquals(maleIcon?.constantState, result1?.constantState)
        assertEquals(femaleIcon?.constantState,result2?.constantState)

    }

    fun testIsMale() {
        val male = "male"
        val female = "female"
        val asdf = "asdf"

        val result1 = Utils.isMale(male)
        val result2 = Utils.isMale(female)
        val result3 = Utils.isMale(asdf)

        assertTrue(result1)
        assertFalse(result2)
        assertFalse(result3)
    }

    fun testGetEmploymentText() {
        val noWork = null
        val ceo = ObjectClass2("CEO", "Leader")

        val result1  = Utils.getEmploymentText(FrienderApplication.application.applicationContext,noWork)
        val result2  = Utils.getEmploymentText(FrienderApplication.application.applicationContext,ceo)


        assertEquals(result1,"Hobo...")
        assertEquals(result2, "Role: CEO\nSkill: Leader")

    }

    fun testGetPlaceText() {

        val place1 = ObjectClass3("Oslo", "Norway")

        val result1 = Utils.getPlaceText(place1)

        assertEquals(result1, "Oslo, Norway")

    }

    fun testGetProfilePictureUrl() {
        val begins1 = "https://randomuser.me/api/portraits/men"
        val begins2 = "https://randomuser.me/api/portraits/women"

        val result1 = Utils.getProfilePictureUrl("male")
        val result2 = Utils.getProfilePictureUrl("female")

        assertTrue(result1.startsWith(begins1))
        assertTrue(result2.startsWith(begins2))

    }

}