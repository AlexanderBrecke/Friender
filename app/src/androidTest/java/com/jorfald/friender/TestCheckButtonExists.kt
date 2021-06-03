package com.jorfald.friender


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TestCheckButtonExists {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testCheckButtonExists() {
        val imageView = onView(
allOf(withId(R.id.check_button),
withParent(withParent(withId(R.id.nav_host_fragment))),
isDisplayed()))
        imageView.check(matches(isDisplayed()))
        }
    }
