package com.workshop.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorDivideTest {

    //Arrange
    private Calculator calculator = new Calculator();

    @Test
    public void divide_2_1_should_be_2() {
        //Act
        int result = calculator.divide(2, 1);
        //Assert
        assertEquals(2, result);
    }

    @Test(expected = DividedByZeroException.class)
    public void divide_2_0_should_be_throw_DivideByZeroException() {
        //Act
        int result = calculator.divide(2, 0);
        //Assert
        assertEquals(2, result);
    }



}
