package com.workshop.calculator;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.workshop.calculator.ResultActivity.RESULT;
import static org.junit.Assert.*;

public class ResultActivityTest {

    @Rule
    public ActivityTestRule<ResultActivity> resultActivityActivityTestRule =
            new ActivityTestRule<>(ResultActivity.class, false, false);

    @Test
    public void send_3_should_show_3() {
        Intent intent = new Intent();
        intent.putExtra(RESULT, "3");
        resultActivityActivityTestRule.launchActivity(intent);

        //Assert
        onView(withId(R.id.tv_result))
                .check(matches(withText("3")));
    }



}