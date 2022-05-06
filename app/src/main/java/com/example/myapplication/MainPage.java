package com.example.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;



import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;

public class MainPage extends AppCompatActivity {

    private Notif notificationHandler;

    public static String LOG_TAG;

    public static int SECRET_KEY=99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        notificationHandler = new Notif(this);
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

    @Override
    protected void onStart() {
        super.onStart();
        notificationHandler.send("Az alkalmazás elindult");
    }

    public void send_email(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"mailto@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Please give the subject");
        intent.putExtra(Intent.EXTRA_TEXT,"Type text here");
        intent.putExtra(Intent.EXTRA_CC,"nails@gmail.com");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));
    }
}
