package com.workshop.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorPlusTest {

    //Arrange
    private Calculator calculator = new Calculator();

    @Test
    public void plus_2_2_should_be_4() {
        //Act
        int result = calculator.plus(2, 2);
        //Assert
        assertEquals(4, result);
    }

    @Test
    public void plus_2_3_should_be_5() {
        //Act
        int result = calculator.plus(2, 3);
        //Assert
        assertEquals(5, result);
    }

}
