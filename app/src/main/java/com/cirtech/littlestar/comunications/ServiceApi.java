package com.cirtech.littlestar.comunications;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import com.cirtech.littlestar.models.User;

public interface ServiceApi {

//    @GET("usersFake")//indicamos el metodo y el endpoint
//    Call<List<User>> getUsersGet();//Recuerda que debes colocar como recibiremos esos datos,en este caso una lista de objs


    @POST("usersFake")//Metodo post
    Call<List<User>> getUsersPost();


    @GET("usersFake")
    Call<String> getValues();

    @GET("users/1")
    Call<String> getStringResponse();
}
