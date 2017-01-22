package com.workshop.calculator.network;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CalculatorAPI {

    @GET("plus")
    Call<Result> plus(
            @Query("first_number") int firstNumber,
            @Query("second_number") int secondNumber);


    public class Result {
        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }

}


