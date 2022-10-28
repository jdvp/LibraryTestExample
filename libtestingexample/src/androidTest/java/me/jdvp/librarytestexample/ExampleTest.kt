import android.app.Application
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.mockk
import me.jdvp.librarytestexample.MainActivity
import me.jdvp.librarytestexample.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleTest {
    @Test
    fun test_buttonClick_11() {
        mockk<Application>()
        launchActivity<MainActivity>()
        Espresso.onView(ViewMatchers.withId(R.id.button_1)).perform(ViewActions.click())

        verifyTextDisplayed("Hello, Button 1!")
        verifyTextDisplayed("Thanks for clicking button 1!")
    }

    @Test
    fun test_buttonClick_12() {
        launchActivity<MainActivity>()
        Espresso.onView(ViewMatchers.withId(R.id.button_2)).perform(ViewActions.click())

        verifyTextDisplayed("Hello, Button 2!")
        verifyTextDisplayed("Thanks for clicking button 2!")
    }

    private fun verifyTextDisplayed(text: String) {
        Espresso.onView(ViewMatchers.withText(text))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}