package uk.infiniti.tech.infinititechandroidpretask.view.login;

import android.content.Context;
import android.util.Log;

import uk.infiniti.tech.infinititechandroidpretask.model.Helper;
import uk.infiniti.tech.infinititechandroidpretask.model.LoginPostBody;
import uk.infiniti.tech.infinititechandroidpretask.model.LoginPreferences;
import uk.infiniti.tech.infinititechandroidpretask.model.UserResponse;
import uk.infiniti.tech.infinititechandroidpretask.model.webservice.API;
import uk.infiniti.tech.infinititechandroidpretask.model.webservice.UserLogin;

public class LoginPresenter implements LoginCommunicator.LoginPresenter, UserLogin.LoginListener{
    private Context context;
    private  LoginCommunicator.LoginView view;
    private String TAG = "LoginPresenter";
    private LoginPostBody loginPostBody = new LoginPostBody();
    private LoginPreferences loginPreferences;
    private Helper helper;

    public LoginPresenter(Context context, LoginCommunicator.LoginView view) {
        this.context = context;
        this.view = view;
        loginPreferences = new LoginPreferences(context);
        helper = new Helper(context);
    }

    @Override
    public void handelLogin(String mobileNo, String password) {
        Log.i(TAG, "Number: "+ mobileNo+ " password: "+ password);
        loginPostBody.setMobile(mobileNo);
        loginPostBody.setPassword(password);

        if (helper.isInternetAvailable()){
            new UserLogin(this).loginPost(API.baseUrl, API.loginUrl(), loginPostBody);
        }else {
            view.loginFailure("No Internet Access");
        }
    }

    @Override
    public void loginResponse(int code, UserResponse userResponse) {

        if (code ==200){
            loginPreferences.setStatus(true);
            loginPreferences.setUserInfo(userResponse);
            loginPreferences.setToken(userResponse.getPayload().getToken());
            //Log.i(TAG, "Token: "+userResponse.getPayload().getToken());
            view.loginSuccess(userResponse.getMessage());
        }else {
            String massage ="";
            switch (code){
                case 400:
                    massage = "Pin length must be 4 digits";
                    break;
                case 404:
                    massage = "The server has not found anything matching the URI given";
                    break;
                case 401:
                    massage =  "Your account will be lock after 4 wrong pin attempt";
                    break;
                case 500:
                    massage = "Internal server error";
                    break;
                default:
                    massage = "Task failed successfully! Retry.";
            }
            view.loginFailure(massage);
        }
       /* if (userResponse.getIssuccess()){
            view.loginSuccess(userResponse.getMessage());
        }else {
            view.loginFailure(userResponse.getMessage());
        }*/
    }

    @Override
    public void loginFailure(String msg) {
        view.loginFailure(msg);
    }
}
