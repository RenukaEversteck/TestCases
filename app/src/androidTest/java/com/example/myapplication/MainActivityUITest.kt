package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityUITest
{


    //used to launch main activity
    @get:Rule
    public val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun  validUser() {

        // Type text and then press the button.
        val email="renuka@gmail.com"
        val pwd="123456"
        onView(withId(R.id.edt_email))
            .perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.edt_pwd))
            .perform(typeText(pwd), closeSoftKeyboard())
        onView(withId(R.id.btn_submit)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.result_txt)).check(matches(withText(Constant.LoginSuccess)))

    }

    @Test
    fun  invalidUser() {

        // Type text and then press the button.
        val email="renu@gmail.com"
        val pwd="123457"
        onView(withId(R.id.edt_email))
            .perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.edt_pwd))
            .perform(typeText(pwd), closeSoftKeyboard())
        onView(withId(R.id.btn_submit)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.result_txt)).check(matches(withText(Constant.LoginFail)))

    }

    @Test
    fun  invalidEmail() {

        // Type text and then press the button.
        val email="renukagmail.com"
        val pwd="123456"
        onView(withId(R.id.edt_email))
            .perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.edt_pwd))
            .perform(typeText(pwd), closeSoftKeyboard())
        onView(withId(R.id.btn_submit)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.result_txt)).check(matches(withText(Constant.InvalidEmail)))

    }

    @Test
    fun  invalidPassword() {

        // Type text and then press the button.
        val email="renuka@gmail.com"
        val pwd="12345"
        onView(withId(R.id.edt_email))
            .perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.edt_pwd))
            .perform(typeText(pwd), closeSoftKeyboard())
        onView(withId(R.id.btn_submit)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.result_txt)).check(matches(withText(Constant.InvalidPwd)))

    }

    @Test
    fun  emptyFeild() {

        // Type text and then press the button.
        val email=""
        val pwd=""
        onView(withId(R.id.edt_email))
            .perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.edt_pwd))
            .perform(typeText(pwd), closeSoftKeyboard())
        onView(withId(R.id.btn_submit)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.result_txt)).check(matches(withText(Constant.EmptyField)))

    }

}