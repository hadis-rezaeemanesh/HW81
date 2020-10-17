package com.example.hw81;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "userName";
    public static final String EXTRA_PASSWORD = "password";
    private static final int REQUEST_CODE_SIGN_UP = 0;
    private static final String BUNDLE_KEY_PASSWORD = "password";
    private static final String BUNDLE_KEY_USER_NAME = "userName";

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mLoginButton;
    private Button mSignUpButton;

    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        if (savedInstanceState != null){
            username = savedInstanceState.getString(EXTRA_USER_NAME);
            password = savedInstanceState.getString(EXTRA_PASSWORD);
        }
        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_KEY_USER_NAME, username);
        outState.putString(BUNDLE_KEY_PASSWORD, password);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode== Activity.RESULT_CANCELED || data==null)
            return;
        if (requestCode == REQUEST_CODE_SIGN_UP) {
            password = data.getStringExtra(EXTRA_PASSWORD);
            username = data.getStringExtra(EXTRA_USER_NAME);
            mEditTextUsername.setText(username );
            mEditTextPassword.setText(password);
        }

    }

    private void findViews() {
        mEditTextUsername = findViewById(R.id.input_username);
        mEditTextPassword = findViewById(R.id.input_password);
        mLoginButton = findViewById(R.id.btn_login);
        mSignUpButton = findViewById(R.id.btn_sign_up);
    }

    private void setListeners() {
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = mEditTextUsername.getText().toString();
                String pas = mEditTextPassword.getText().toString();
                if (usr .equals(username)  && pas .equals(password) ) {
                    Snackbar.make(findViewById(R.id.container), "Login", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(findViewById(R.id.container), "Username or Password is incorrect", Snackbar.LENGTH_LONG)
                            .show();
                }

            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                intent.putExtra(EXTRA_USER_NAME, String.valueOf(mEditTextUsername.getText()));
                intent.putExtra(EXTRA_PASSWORD, String.valueOf(mEditTextPassword.getText()));
                startActivityForResult(intent, REQUEST_CODE_SIGN_UP);
            }
        });
    }


}