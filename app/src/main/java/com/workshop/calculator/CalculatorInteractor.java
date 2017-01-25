package com.workshop.calculator;

import android.util.Log;

import com.workshop.calculator.network.CalculatorAPI;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

interface MyListener {
    void onAPISuccess(CalculatorAPI.UserInformation userInformation);
}

class JsonInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        okhttp3.Response response = chain.proceed(request);
        String rawJson = response.body().string();

        // Re-create the response before returning it because body can be read only once
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), rawJson)).build();
    }
}

public class CalculatorInteractor {

    public static String CALCULATOR_ENDPOINT = "http://10.0.2.2:8882/";
    private Retrofit retrofit;
    private CalculatorListener calculatorListener;
    private MyListener myListener;

    public CalculatorInteractor(CalculatorListener calculatorListener) {
        this.calculatorListener = calculatorListener;
    }

    public CalculatorInteractor(CalculatorListener calculatorListener, MyListener myListener) {
        this.calculatorListener = calculatorListener;
        this.myListener = myListener;
    }

    public void plus(int firstNumber, int secondNumber) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new JsonInterceptor());
        retrofit = new Retrofit.Builder()
                .baseUrl(CALCULATOR_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        CalculatorAPI calculatorAPI = retrofit.create(CalculatorAPI.class);
//        final Call<CalculatorAPI.Result> call =
//                calculatorAPI.plus(firstNumber, secondNumber);

        CalculatorAPI.MyRequest myRequest = new CalculatorAPI.MyRequest("somkiat", "xxxx");
        final Call<CalculatorAPI.UserInformation> call =
                calculatorAPI.getByUser(2, myRequest);

        call.enqueue(new Callback<CalculatorAPI.UserInformation>() {
            @Override
            public void onResponse(Call<CalculatorAPI.UserInformation> call, Response<CalculatorAPI.UserInformation> response) {
//                Log.d("test", "onResponse: " + response.body());
//                calculatorListener.onSuccess(response.body().toString());
                myListener.onAPISuccess(response.body());
            }

            @Override
            public void onFailure(Call<CalculatorAPI.UserInformation> call, Throwable t) {
                Log.d("test", "onFailure: ");
            }
        });

//        call.enqueue(new Callback<CalculatorAPI.Result>() {
//
//            @Override
//            public void onResponse(Call<CalculatorAPI.Result> call, Response<CalculatorAPI.Result> response) {
//                String result = response.body().getResult();
//                Log.d("TRY", "onResponse: " + response.body().toString());
//                calculatorListener.onSuccess(result);
//            }
//
//            @Override
//            public void onFailure(Call<CalculatorAPI.Result> call, Throwable t) {
//                Log.d("TRY", "onFailure: " + t.toString());
//            }
//        });
    }


}
