package com.cirtech.littlestar.services;

import android.util.Log;

import com.cirtech.littlestar.comunications.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RegisterUser {

    private String name;
    private String email;
    private String password;
    private String password_confirmation;

    private GetJSONListener getJSONListener;

    public RegisterUser(String name, String email, String password, String password_confirmation){

        this.name =  name;
        this.email =  email;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

    public String execute(GetJSONListener getJSONListener) {
        final  String url = "http://ec2-18-221-185-30.us-east-2.compute.amazonaws.com";
//        Log.i("teste login auth","passou inBackground loginzao");


        this.getJSONListener = getJSONListener;

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(url)
                .build();

        ServiceApi service = retrofit.create(ServiceApi.class);

        Call<String> stringCall = service.register(this.name, this.email,this.password, this.password_confirmation);

        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                    String responseString = response.body();
                    Log.i("result","cadastro efetuado com sucesso");
                    getJSONListener.onRemoteCallComplete(responseString,"ok");
                }
                else {

                    String responseString = response.message();
//                    JSONObject jObjError = new JSONObject(response.errorBody().string());
//                    String responseString = jObjError.getJSONObject("error").getString("message");
                    getJSONListener.onRemoteCallComplete(responseString,"error");
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                String responseString = t.toString();
                Log.i("resposta_string",responseString);
//                getJSONListener.onRemoteCallComplete(responseString,"error");
            }
        });
        return null;
    }


    public interface GetJSONListener {
        public void onRemoteCallComplete(String jsonFromNet,String statusResponse);
    }

    public class APIError {
        private String message;

        public String getMessage() {
            return message;
        }
    }
}

