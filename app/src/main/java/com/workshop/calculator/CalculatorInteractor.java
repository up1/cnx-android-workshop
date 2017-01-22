package com.workshop.calculator;

import com.workshop.calculator.network.CalculatorAPI;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

interface CalculatorListener {
    void onSuccess(String result);
}

public class CalculatorInteractor {

    public static String CALCULATOR_ENDPOINT = "http://10.0.0.75:8882/";
    private Retrofit retrofit;
    private CalculatorListener calculatorListener;

    public CalculatorInteractor(CalculatorListener calculatorListener) {
        this.calculatorListener = calculatorListener;
    }


    public void plus(int firstNumber, int secondNumber) {
        retrofit = new Retrofit.Builder()
                .baseUrl(CALCULATOR_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CalculatorAPI calculatorAPI = retrofit.create(CalculatorAPI.class);
        final Call<CalculatorAPI.Result> call =
                calculatorAPI.plus(firstNumber, secondNumber);

        call.enqueue(new Callback<CalculatorAPI.Result>() {

            @Override
            public void onResponse(Call<CalculatorAPI.Result> call, Response<CalculatorAPI.Result> response) {
                String result = response.body().getResult();
                calculatorListener.onSuccess(result);
            }

            @Override
            public void onFailure(Call<CalculatorAPI.Result> call, Throwable t) {

            }
        });
    }


}
