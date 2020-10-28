package com.cirtech.littlestar.services;

import android.os.AsyncTask;
import android.util.Log;

import com.cirtech.littlestar.comunications.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class AuthenticateUser extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        final  String url = "http://ec2-18-221-185-30.us-east-2.compute.amazonaws.com";
        Log.i("teste login auth","passou inBackground loginzao");

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(url)
                .build();

        ServiceApi service = retrofit.create(ServiceApi.class);

        Call<String> stringCall = service.authenticate("iuri5@gmail.com","12345");

        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String responseString = response.body();
                    Log.i("resposta_string",responseString);
//                        Log.i("resposta_string","deu certo");
                }
                else {
                    Log.i("resposta_string","nao deu certo");
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                String responseString = t.toString();
                Log.i("resposta_string",responseString);
            }
        });
        return null;
    }
}
