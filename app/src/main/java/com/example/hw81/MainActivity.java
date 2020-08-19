package com.example.hw81;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mLoginButton;
    private Button mSignUpButton;
    String username;
    String password;
    private ViewGroup mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void findViews(){
        mEditTextUsername = findViewById(R.id.input_username);
        mEditTextPassword = findViewById(R.id.input_pasword);
        mLoginButton = findViewById(R.id.btn_login);
        mSignUpButton = findViewById(R.id.btn_sign_up);
    }

    private void setListeners(){
      mLoginButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String usr = mEditTextUsername.getText().toString();
              String pas = mEditTextPassword.getText().toString();
              if (usr == username && pas == password ){
                   Snackbar.make(mView, "Login", Snackbar.LENGTH_LONG ).show();
              }else {
                  Snackbar.make(mView, "Username or Password is incorrect",Snackbar.LENGTH_LONG )
                          .show();
              }

          }
      });

      mSignUpButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, SignupActivity.class);
              intent.putExtra(EXTRA_USER_NAME, username );
              intent.putExtra(EXTRA_PASSWORD, password);
              startActivityForResult(intent, 0);
          }
      });
    }

    private boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }



}