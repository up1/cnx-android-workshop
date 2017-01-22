package com.workshop.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainControllerMinusTest {

    boolean called = false;

    class SpyMainView implements MainView {

        @Override
        public void sendResult(String result) {
            called = true;
        }
    }

    @Test
    public void minus() {
        //Arrange
        MainView spyMainView = new SpyMainView();
        MainController mainController = new MainController(spyMainView);

        //Act
        mainController.minus();

        //Assert ?
        assertTrue("Method sendResult must be called", called);

    }

}