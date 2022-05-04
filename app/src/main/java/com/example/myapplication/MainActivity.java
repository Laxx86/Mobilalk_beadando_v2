package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int SECRET_KEY = 99;
    /**Username és Password beolvasó változók az EditText mezőből */
    EditText userNameReader;
    EditText passwordReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Username és Password beolvasása az EditText mezőből */
        userNameReader = findViewById(R.id.EditTextUserNameInsertion);
        passwordReader = findViewById(R.id.EditTextUserPasswordInsertion);

    }

    public void Login(View view) {

        EditText userName = findViewById(R.id.EditTextUserNameInsertion);
        EditText password = findViewById(R.id.EditTextUserPasswordInsertion);
    }

    public void LoginWithGoogle(View view) {
    }

    public void LoginWithFacebook(View view) {
    }

    public void cancel(View view) {
        finish();
    }
}