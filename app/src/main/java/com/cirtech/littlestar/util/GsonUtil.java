package com.cirtech.littlestar.util;

import android.util.Log;
import com.cirtech.littlestar.models.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GsonUtil {

    public static String getGson1() {


        User user = new User(123, "João", "Silva", "joaoSilva");
        Gson gson = new Gson();
        //int id, String name, String lastName, String nickName

        String userJSONString = gson.toJson(user);
        Log.i("Gson Teste: ", userJSONString);
        return userJSONString;
    }

    public static Map json_decode(String jsonString){
//        String jsonString = "{\"titulo\":\"Os Arquivos JSON\",\"ano\":1998,\"genero\":\"Ficção\"}";
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Map.class);
    }

    public static Map json_decode2() throws JSONException {
        String jsonString = "{\"titulo\":\"Os Arquivos JSON\",\"ano\":1998,\"genero\":\"Ficção\"}";
        JSONObject obj = new JSONObject(jsonString);

        HashMap <String,String> map = new HashMap<>();
        for (Iterator<String> it = obj.keys(); it.hasNext(); ) {
            String key = it.next();
            map.put(key,obj.getString(key));
        }
        return map;

//        for (Object value : map.values()) {
//            // ...
//        }
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
//        map.forEach((key,value)->{
//            Log.i("teste","teste");
//        });
    }


}
