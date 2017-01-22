package com.workshop.calculator;


import android.support.annotation.NonNull;

class MainController implements CalculatorListener {

    private MainView mainView;
    private CalculatorInteractor calculatorInteractor;
    private int firstNumber;
    private int secondNumber;

    MainController(MainView mainView) {
        this.mainView = mainView;
    }

    void plus() {
//        Calculator calculator = getCalculator();
//        int result = calculator.plus(firstNumber, secondNumber);
//        mainView.sendResult(String.valueOf(result));

        calculatorInteractor = new CalculatorInteractor(this);
        calculatorInteractor.plus(firstNumber, secondNumber);
    }

    @Override
    public void onSuccess(String result) {
        mainView.sendResult(result);
    }

    @NonNull
    private Calculator getCalculator() {
        return new Calculator();
    }

    void minus() {
        Calculator calculator = getCalculator();
        int result = calculator.minus(firstNumber, secondNumber);
        mainView.sendResult(String.valueOf(result));
    }

    void divide() {
        Calculator calculator = getCalculator();
        try {
            int result = calculator.divide(firstNumber, secondNumber);
            mainView.sendResult(String.valueOf(result));
        }catch (DividedByZeroException e) {
            mainView.sendResult("หาร 0 ไม่ได้นะ");
        }
    }

    void setupInput(String firstNumber, String secondNumber) {
        this.firstNumber = Integer.parseInt(firstNumber);
        this.secondNumber = Integer.parseInt(secondNumber);
    }
}