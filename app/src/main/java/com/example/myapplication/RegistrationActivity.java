package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.crypto.SecretKey;

public class RegistrationActivity extends AppCompatActivity {

    EditText editTextNameRegister;
    EditText editTextEmailAddress;
    EditText editTextPhoneNumber;
    EditText editUserNameRegister;
    EditText editTextPasswordRegister;
    EditText editTextPasswordRepeat;

    public static String LOG_TAG;
    private FirebaseAuth loginAuth;



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

        loginAuth = FirebaseAuth.getInstance();

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

        loginAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(LOG_TAG, "Sikeres regisztráció");
                    finish();
                } else {
                    Log.d(LOG_TAG, "Sikertelen regisztráció");
                    Toast.makeText(RegistrationActivity.this, "Sikertelen regisztráció" + task.getException().getMessage(),  Toast.LENGTH_LONG).show();
                }
            }
        });

        finish();
    }
}
