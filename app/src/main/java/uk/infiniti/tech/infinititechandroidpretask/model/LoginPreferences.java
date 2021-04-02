package uk.infiniti.tech.infinititechandroidpretask.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class LoginPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson ;
    private String json;
    public static final String ISLOGGEDIN = "isLoggedIn";
    public static final String TOKEN = "token";
    public static final String USER_INFO = "user_info";

    public LoginPreferences(Context context){
        sharedPreferences = context.getSharedPreferences("UserLoginPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
    }

    public void setToken(String token){
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public void setUserInfo(UserResponse userResponse){
        json = gson.toJson(userResponse);
        editor.putString(USER_INFO, json);
        editor.commit();
    }

    public UserResponse getUserInfo(){
        json = sharedPreferences.getString(USER_INFO, null);
        return  gson.fromJson(json, UserResponse.class);
    }

    public void setStatus(boolean status){
        editor.putBoolean(ISLOGGEDIN,status);
        editor.commit();
    }

    public boolean getStatus(){
        return sharedPreferences.getBoolean(ISLOGGEDIN,false);
    }


}
