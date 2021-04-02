package uk.infiniti.tech.infinititechandroidpretask.model.webservice;

import android.util.Log;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.infiniti.tech.infinititechandroidpretask.model.LoginPostBody;
import uk.infiniti.tech.infinititechandroidpretask.model.UserResponse;
import uk.infiniti.tech.infinititechandroidpretask.view.login.LoginPresenter;

public class UserLogin {
    private LoginPresenter context;
    private RetrofitListener retrofitListener;
    private UserResponse userResponse;
    private String TAG = "UserLogin";
    private LoginListener listener;
    private int code;

    public UserLogin(LoginPresenter context) {
        this.context = context;

        listener = (LoginListener) context;
    }

    public void loginPost(final String baseUrl, final String prefix, LoginPostBody userCredential) {
        Log.i(TAG,"url: "+baseUrl+prefix);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(okHttpClient)
                .build();

        retrofitListener = retrofit.create(RetrofitListener.class);

        Call<UserResponse> call = retrofitListener.postLogin(prefix,userCredential);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (!response.isSuccessful()) {
                    listener.loginResponse(response.code(), response.body());
                    Log.i(TAG, "respoonse : "+response.code());
                    return;
                }
               userResponse = response.body();
                code = response.code();
                Gson gson=new Gson();
                String res = gson.toJson(userResponse);
                Log.i(TAG, "Response" + res + " Code: "+ response.code());
                //wsResponseListener.success(res, baseUrl + prefix);

                listener.loginResponse(code, userResponse );

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.i(TAG,"Failed!!"+t.getMessage());
                listener.loginFailure(t.getMessage());
            }
        });
    }

    public interface LoginListener{
        void loginResponse(int code,  UserResponse userResponse);
        void loginFailure(String msg);
    }
}
