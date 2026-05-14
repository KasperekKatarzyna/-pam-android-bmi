package com.example.zadaniebmi

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {
    @Test
    fun bmiCalculatorShowsResultAfterEnteringData() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.buttonBmi)).perform(click())
            onView(withId(R.id.editWeight)).perform(typeText("70"), closeSoftKeyboard())
            onView(withId(R.id.editHeight)).perform(typeText("175"), closeSoftKeyboard())
            onView(withId(R.id.buttonCalculateBmi)).perform(click())

            onView(withId(R.id.textBmiResult)).check(matches(withText(containsString("22"))))
            onView(withId(R.id.textBmiInterpretation))
                .check(matches(withText(containsString("Waga prawidłowa"))))
        }
    }

    @Test
    fun shoppingListItemCanBeMarkedAsPurchased() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.buttonShoppingList)).perform(click())
            onView(withText(containsString("Pomidor"))).perform(click())

            onView(withText(containsString("Pomidor"))).check(matches(isChecked()))
        }
    }
}
