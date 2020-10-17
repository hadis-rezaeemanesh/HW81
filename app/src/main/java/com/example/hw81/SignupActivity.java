package com.example.hw81;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.hw81.MainActivity.EXTRA_PASSWORD;
import static com.example.hw81.MainActivity.EXTRA_USER_NAME;

public class SignupActivity extends AppCompatActivity {

    public static final String USER_NAME_SIGN_UP = "userNameSignUp";
    public static final String PASSWORD_SIGN_UP = "passwordSignUp";
    private EditText mSignUpUsername;
    private EditText mSignUpPassword;
    private Button mButtonSignUp;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();

        if (savedInstanceState != null){
            username = savedInstanceState.getString(USER_NAME_SIGN_UP);
            password = savedInstanceState.getString(PASSWORD_SIGN_UP);
        }
        setListeners();

        username = getIntent().getStringExtra(EXTRA_USER_NAME);
        mSignUpUsername.setText(username);
        password = getIntent().getStringExtra(EXTRA_PASSWORD);
        mSignUpPassword.setText(password);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(USER_NAME_SIGN_UP, username);
        outState.putString(PASSWORD_SIGN_UP, password);
    }

    private void findViews(){
        mSignUpUsername = findViewById(R.id.input_sign_up_username);
        mSignUpPassword = findViewById(R.id.input_sign_up_password);
        mButtonSignUp = findViewById(R.id.btn_sign_up);
    }

    private void setListeners(){
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(EXTRA_USER_NAME, String.valueOf(mSignUpUsername.getText()));
                intent.putExtra(EXTRA_PASSWORD, String.valueOf(mSignUpPassword.getText()));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}