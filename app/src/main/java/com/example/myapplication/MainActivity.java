package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {
    private static final int SECRET_KEY = 99;
    /**Username és Password beolvasó változók az EditText mezőből */
    EditText userNameReader;
    EditText passwordReader;
    private FirebaseAuth loginAuth;
    private String LOG_TAG;
    private boolean logged_in = false;
    private GoogleSignInClient mGoogleSingIn;
    public static final int RC_SIGN_IN = 111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (logged_in == false) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.mainpage);
        }


        /**Username és Password beolvasása az EditText mezőből */
        userNameReader = findViewById(R.id.EditTextUserNameInsertion);
        passwordReader = findViewById(R.id.EditTextUserPasswordInsertion);
        loginAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gLogin = new GoogleSignInOptions.Builder(GoogleSignInOptions .DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        mGoogleSingIn = GoogleSignIn.getClient(this, gLogin);


    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                Log.w(LOG_TAG, "Google sign in failed", e);
            }
        }
    }

    public void firebaseAuthWithGoogle(String idToken) {
        AuthCredential googleCredential = GoogleAuthProvider.getCredential(idToken, null);
        loginAuth.signInWithCredential(googleCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(LOG_TAG, "Login succesfull!");
                    logged_in = true;
                    finish();
                } else {
                    Log.d(LOG_TAG, "Login failed!");
                    Toast.makeText(MainActivity.this, "Login failed!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });;
    }

    public void Login(View view) {

        String userName = userNameReader.getText().toString();
        String password = passwordReader.getText().toString();


        do {
            loginAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(LOG_TAG, "Login succesfull!");
                        logged_in = true;
                        finish();
                    } else {
                        Log.d(LOG_TAG, "Login failed!");
                        Toast.makeText(MainActivity.this, "Login failed!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        } while ((userName == "") || (password == ""));
    }

    public void LoginWithGoogle(View view) {
        Intent googleSignInIntent = mGoogleSingIn.getSignInIntent();
        startActivityForResult(googleSignInIntent, RC_SIGN_IN);


    }



    public void cancel(View view) {
        finish();
    }
}