package com.example.ecommerceapp.retrofit;

import com.example.ecommerceapp.model.Result;


import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("json")
    Call<Result> getProduct();
}
