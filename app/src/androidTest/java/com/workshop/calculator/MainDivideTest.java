package com.workshop.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainDivideTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void minus_2_2_should_be_0() {
        //Action
        onView(withId(R.id.edt_firstNumber))
                .perform(typeText("2"));
        onView(withId(R.id.edt_secondNumber))
                .perform(typeText("2"));
        onView(withId(R.id.btn_minus))
                .perform(click());

        //Assert
        onView(withId(R.id.tv_result))
                .check(matches(withText("0")));

    }

    @Test
    public void divide_2_2_should_be_1() {
        //Action
        onView(withId(R.id.edt_firstNumber))
                .perform(typeText("2"));
        onView(withId(R.id.edt_secondNumber))
                .perform(typeText("2"));
        onView(withId(R.id.btn_divide))
                .perform(click());

        //Assert
        onView(withId(R.id.tv_result))
                .check(matches(withText("1")));

    }

    @Test
    public void divide_2_0_should_be_show_error_message() {
        //Action
        onView(withId(R.id.edt_firstNumber))
                .perform(typeText("2"));
        onView(withId(R.id.edt_secondNumber))
                .perform(typeText("0"));
        onView(withId(R.id.btn_divide))
                .perform(click());

        //Assert
        onView(withId(R.id.tv_result))
                .check(matches(withText("หาร 0 ไม่ได้นะ")));

    }



}






