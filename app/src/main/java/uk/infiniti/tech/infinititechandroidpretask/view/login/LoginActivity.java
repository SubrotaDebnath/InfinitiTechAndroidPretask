package uk.infiniti.tech.infinititechandroidpretask.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import uk.infiniti.tech.infinititechandroidpretask.R;
import uk.infiniti.tech.infinititechandroidpretask.model.LoginPreferences;
import uk.infiniti.tech.infinititechandroidpretask.view.dashboard.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginCommunicator.LoginView {
    private Button loginBTN;
    private LoginPresenter presenter;
    private EditText mobileET, passwordET;
    private TextView errorTV;
    private String TAG = "LoginActivity";
    private LoginPreferences loginPreferences;
    private ProgressBar progressBar;

    @Override
    protected void onStart() {
        loginPreferences = new LoginPreferences(this);
        if (loginPreferences.getStatus()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, this);

        loginBTN = findViewById(R.id.loginButton);
        mobileET = findViewById(R.id.mobileET);
        passwordET = findViewById(R.id.passwordET);
        errorTV = findViewById(R.id.errorTV);
        progressBar = findViewById(R.id.progressBar);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobileNumber = mobileET.getText().toString().trim();
                String pin = passwordET.getText().toString().trim();

                if (mobileNumber != null && !mobileNumber.equals("")) {
                    if (mobileNumber.charAt(0) == '0') {
                        mobileET.setError("First number 0 isn't allow.");
                    } else {
                        if (mobileNumber.length() != 10) {
                            mobileET.setError("Mobile number will be 10 digit.");
                        } else {
                            if (pin != null && !pin.equals("")) {
                                if (pin.length() != 4) {
                                    passwordET.setError("Pin will be 4 digit.");
                                } else {
                                    progressBar.setVisibility(View.VISIBLE);
                                    presenter.handelLogin(mobileNumber, pin);
                                }
                            } else {
                                passwordET.setError("Empty Field");
                            }
                        }
                    }
                } else {
                    mobileET.setError("Empty Field.");
                }
            }
        });


        mobileET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && !s.equals("") && s.length() > 0) {
                    Log.i(TAG, s.charAt(0) + " is first char.");
                    if (s.charAt(0) == '0') {
                        errorTV.setText("First number 0 isn't allow.");
                    } else {
                        errorTV.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void loginSuccess(String message) {
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void loginFailure(String message) {
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }
}