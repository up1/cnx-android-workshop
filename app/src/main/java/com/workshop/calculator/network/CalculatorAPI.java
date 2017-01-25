package com.workshop.calculator.network;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CalculatorAPI {

    @GET("plus")
    Call<Result> plus(
            @Query("first_number") int firstNumber,
            @Query("second_number") int secondNumber);

    @POST("user/{user_id}")
    Call<UserInformation> getByUser(@Path("user_id") int userId,
                                    @Body MyRequest myRequest);


    public class MyRequest {
        private String username;
        private String password;

        public MyRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public class Result {
        private String result;

        public String getResult() {
            return result;
        }
        
    }

    public class UserInformation {
        @Override
        public String toString() {
            return "UserInformation{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

}


