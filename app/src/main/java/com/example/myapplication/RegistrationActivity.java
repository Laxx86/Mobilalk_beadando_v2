package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import javax.crypto.SecretKey;

public class RegistrationActivity extends AppCompatActivity {

    EditText editTextNameRegister;
    EditText editTextEmailAddress;
    EditText editTextPhoneNumber;
    EditText editUserNameRegister;
    EditText editTextPasswordRegister;
    EditText editTextPasswordRepeat;

    public static String LOG_TAG;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        int secretKey = getIntent().getIntExtra("SECRET_KEY",0);

        if (secretKey != 99) {
            finish();
        }

        editTextNameRegister = findViewById(R.id.editTextNameRegister);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editUserNameRegister = findViewById(R.id.editUserNameRegister);
        editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister);
        editTextPasswordRepeat = findViewById(R.id.editTextPasswordRepeat);

    }

    public void Cancel(View view) {
        finish();
    }

    public void Registration(View view) {
        String name = editTextNameRegister.getText().toString();
        String email = editTextEmailAddress.getText().toString();
        String phone = editTextPhoneNumber.getText().toString();
        String user = editUserNameRegister.getText().toString();
        String password = editTextPasswordRegister.getText().toString();
        String passAgain = editTextPasswordRepeat.getText().toString();

        if (!password.equals(passAgain)) {
            Log.e(LOG_TAG, "Nem egyezik meg a két jelszó!");
            return;
        }
    }
}
