package com.workshop.calculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.workshop.calculator.ResultActivity.RESULT;

interface MainView {
    void sendResult(String result);
}

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText edtFirstNumber;
    private EditText edtSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    private void initial() {
        edtFirstNumber = (EditText) findViewById(R.id.edt_firstNumber);
        edtSecondNumber = (EditText)findViewById(R.id.edt_secondNumber);
    }

    public void plus(View view) {
        MainController mainController = getMainController();
        mainController.plus();
    }

    public void minus(View view) {
        MainController mainController = getMainController();
        mainController.minus();
    }

    public void divide(View view) {
        MainController mainController = getMainController();
        mainController.divide();
    }

    @NonNull
    private MainController getMainController() {
        MainController mainController = new MainController(this);
        mainController.setupInput(edtFirstNumber.getText().toString(),
                                  edtSecondNumber.getText().toString());
        return mainController;
    }

    public void sendResult(String result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(RESULT, result);
        startActivity(intent);
    }

}
