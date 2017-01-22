package com.workshop.calculator;

class Calculator {

    int plus(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    int divide(int firstNumber, int secondNumber) {
        if(secondNumber == 0) {
            throw new DividedByZeroException();
        }
        return  firstNumber/secondNumber;
    }
}
