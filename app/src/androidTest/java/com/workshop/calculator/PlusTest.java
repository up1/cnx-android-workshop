package com.workshop.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PlusTest {

    private int firstNumber;
    private int secondNumber;
    private int expectedResult;

    public PlusTest(int firstNumber, int secondNumber, int expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Parameters(name = "test case {index}: {0}+{1}={2}")
    public static List<Object[]>  xxxx() {
        return Arrays.asList( new Object[][] {
                {1, 2, 3},
                {2, 2, 4},
                {2, 3, 5},
        } );
    }

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void plus() {
        //Action
        onView(withId(R.id.edt_firstNumber))
                .perform(typeText(String.valueOf(firstNumber)));
        onView(withId(R.id.edt_secondNumber))
                .perform(typeText(String.valueOf(secondNumber)));
        onView(withId(R.id.btn_plus))
                .perform(click());

        //Assert
        onView(withId(R.id.tv_result))
                .check(matches(withText(String.valueOf(expectedResult))));

    }
}






