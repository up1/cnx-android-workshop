package com.workshop.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainControllerDivideTest {
    boolean called = false;

    class SpyMainView implements MainView {

        @Override
        public void sendResult(String result) {
            called = true;
        }
    }

    @Test
    public void divide_with_zero_exception(){
        //Arrange
        MainView spyMainView = new SpyMainView();
        MainController mainController = new MainController(spyMainView);
        mainController.setupInput("222", "0");

        //Act
        mainController.divide();

        //Assert ?
        assertTrue("Method sendResult must be called", called);

    }

    @Test
    public void divide(){
        //Arrange
        MainView spyMainView = new SpyMainView();
        MainController mainController = new MainController(spyMainView);
        mainController.setupInput("222", "2");
        //Act
        mainController.divide();

        //Assert ?
        assertTrue("Method sendResult must be called", called);

    }

}