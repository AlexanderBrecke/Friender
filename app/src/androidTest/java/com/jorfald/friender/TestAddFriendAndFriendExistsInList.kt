package com.jorfald.friender


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TestAddFriendAndFriendExistsInList {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAddFriendAndFriendExistsInList() {
        val appCompatImageView = onView(
allOf(withId(R.id.check_button),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment),
0),
2),
isDisplayed()))
        appCompatImageView.perform(click())
        
        val materialButton = onView(
allOf(withId(R.id.my_friends_button), withText("My Friends"),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment),
0),
3),
isDisplayed()))
        materialButton.perform(click())
        
        val viewGroup = onView(
allOf(withParent(withParent(withId(R.id.friends_recycler))),
isDisplayed()))
        viewGroup.check(matches(isDisplayed()))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
