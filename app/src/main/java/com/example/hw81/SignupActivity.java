package com.example.hw81;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    public static final String USER_NAME_SIGN_UP = "userNameSignUp";
    public static final String PASSWORD_SIGN_UP = "passwordSignUp";
    private EditText mSignUpUsername;
    private EditText mSignUpPassword;
    private Button mButtonSignUp;

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent startIntent = getIntent();
        findViews();
        setListeners();
        if (savedInstanceState != null){
            mSignUpPassword.setText(savedInstanceState.getInt(USER_NAME_SIGN_UP));
            mSignUpPassword.setText(savedInstanceState.getInt(PASSWORD_SIGN_UP));
        }

        username = getIntent().getStringExtra(MainActivity.EXTRA_USER_NAME);
        mSignUpUsername.setText(username);
        password = getIntent().getStringExtra(MainActivity.EXTRA_PASSWORD);
        mSignUpPassword.setText(password);
    }

    private void findViews(){
        mSignUpUsername = findViewById(R.id.input_username);
        mSignUpPassword = findViewById(R.id.input_pasword);
        mButtonSignUp = findViewById(R.id.btn_sign_up);
    }

    private void setListeners(){
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivityForResult(intent, 1);

            }
        });
    }
}