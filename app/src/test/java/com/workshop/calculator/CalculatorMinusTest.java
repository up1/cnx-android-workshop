package com.workshop.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorMinusTest {

    //Arrange
    private Calculator calculator = new Calculator();

    @Test
    public void minus_2_2_should_be_0() {
        //Act
        int result = calculator.minus(2, 2);
        //Assert
        assertEquals(0, result);
    }

    @Test
    public void minus_5_2_should_be_3() {
        //Act
        int result = calculator.minus(5, 2);
        //Assert
        assertEquals(3, result);
    }


}
