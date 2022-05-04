package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    public static int SECRET_KEY=99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
    }

    public void mainactivity(View view) {
        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);
    }

    /**REgisztráció intentje, ezzel aktiváljuk a RegistrationActivity-t */
    public void registeractivity(View view) {
        Intent registerIntent = new Intent(this, RegistrationActivity.class);
        registerIntent.putExtra("SECRET_KEY", 99);
        startActivity(registerIntent);
    }


    public void calendarActivity(View view) {
        Intent calendarIntent = new Intent(this, CalendarActivity.class);
        startActivity(calendarIntent);
    }
}
