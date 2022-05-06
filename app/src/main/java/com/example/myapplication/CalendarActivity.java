package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class CalendarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private static String LOG_TAG;

    private FirebaseUser user;
    private RecyclerView recyclerView;
    private int gridNumber = 1;

    private Notif notificationHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        spinner = findViewById(R.id.services);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.services, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Log.d(LOG_TAG, "Helyes user");
        } else {
            Log.d(LOG_TAG, "Hibás user");
            finish();
        }

        notificationHandler = new Notif(this);
    }

        public void cancel(View view) {
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String selectedItem = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void reserve(View view) {
        notificationHandler.send("Sajnos ez a gomb csak ennyit tud :(");
    }
}
