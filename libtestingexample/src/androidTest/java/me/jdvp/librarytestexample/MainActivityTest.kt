package me.jdvp.librarytestexample

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun test_buttonClick_1() {
        composeTestRule.onNodeWithText("Button 1").performClick()

        // Compose's native wait API
        composeTestRule.waitUntilAtLeastOneExists(hasText("Hello, Button 1!"), timeoutMillis = 10000)
        
        composeTestRule.onNodeWithText("Hello, Button 1!").assertExists()
        composeTestRule.onNodeWithText("Thanks for clicking button 1!").assertExists()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun test_buttonClick_2() {
        composeTestRule.onNodeWithText("Button 2").performClick()

        composeTestRule.waitUntilAtLeastOneExists(hasText("Hello, Button 2!"), timeoutMillis = 10000)

        composeTestRule.onNodeWithText("Hello, Button 2!").assertExists()
        composeTestRule.onNodeWithText("Thanks for clicking button 2!").assertExists()
    }
}
