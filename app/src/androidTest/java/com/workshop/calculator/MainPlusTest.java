package com.workshop.calculator;

import android.content.Intent;
import android.support.test.espresso.core.deps.guava.base.Charsets;
import android.support.test.espresso.core.deps.guava.io.Resources;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainPlusTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class, true, false);


    private MockWebServer server;

    @Before
    public void startMockWebServer() throws IOException {
        server = new MockWebServer();
        server.start();
        CalculatorInteractor.CALCULATOR_ENDPOINT = server.url("/").toString();
    }

    @After
    public void stopServer() throws Exception {
        server.shutdown();
    }

    private String getDataFromFile(String resource) throws IOException {
        return Resources.toString(Resources.getResource(resource), Charsets.UTF_8);
    }


    @Test
    public void plus_2_3_should_be_5() throws IOException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(getDataFromFile("result.json")));

        //Launch activity
        Intent intent = new Intent();
        mainActivityActivityTestRule.launchActivity(intent);

        //Action
        onView(withId(R.id.edt_firstNumber))
                .perform(replaceText("2"));
        onView(withId(R.id.edt_secondNumber))
                .perform(replaceText("3"));
        onView(withId(R.id.btn_plus))
                .perform(click());

        //Assert
        onView(withId(R.id.tv_result))
                .check(matches(withText("5")));

    }


}






