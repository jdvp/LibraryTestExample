package me.jdvp.librarytestexample

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun test_buttonClick_1() {
        launchActivity<MainActivity>()
        onView(withId(R.id.button_1)).perform(click())

        verifyTextDisplayed("Hello, Button 1!")
        verifyTextDisplayed("Thanks for clicking button 1!")
    }

    @Test
    fun test_buttonClick_2() {
        launchActivity<MainActivity>()
        onView(withId(R.id.button_2)).perform(click())

        verifyTextDisplayed("Hello, Button 2!")
        verifyTextDisplayed("Thanks for clicking button 2!")
    }

    private fun verifyTextDisplayed(text: String) {
        onView(withText(text))
            .check(matches(isDisplayed()))
    }
}