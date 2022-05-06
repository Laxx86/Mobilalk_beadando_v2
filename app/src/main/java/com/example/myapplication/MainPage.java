package com.example.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;

public class MainPage extends AppCompatActivity {

    public static String LOG_TAG;

    public static int SECRET_KEY=99;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        button = (Button) findViewById(R.id.registration);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(MainPage.this, R.anim.rotate);
                button.startAnimation(anim);
            }
        });
    }

    public void mainactivity(View view) {
        Intent loginIntent = new Intent(this, MainActivity.class);
        Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(loginIntent, b);
    }

    /**REgisztráció intentje, ezzel aktiváljuk a RegistrationActivity-t */
    public void registeractivity(View view) {
        Intent registerIntent = new Intent(this, RegistrationActivity.class);
        registerIntent.putExtra("SECRET_KEY", 99);
        Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(registerIntent, b);
    }


    public void calendarActivity(View view) {
        Intent calendarIntent = new Intent(this, CalendarActivity.class);
        Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(calendarIntent ,b);
    }

}
