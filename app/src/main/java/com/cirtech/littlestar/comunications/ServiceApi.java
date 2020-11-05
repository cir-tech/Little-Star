package com.cirtech.littlestar.comunications;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @FormUrlEncoded
    @POST("api/login")
    Call<String> authenticate(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/register")
    Call<String> register(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("password_confirmation") String password_confirmation);
}
