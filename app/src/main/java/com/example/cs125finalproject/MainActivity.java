package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUM = "com.example.cs125finalproject.EXTRA_NUM";

    private Button fifteenMiles;
    private Button thirtyMiles;
    private Button fiftyMiles;
    public int mileRadius;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fifteenMiles = (Button) findViewById(R.id.fifteenMiles);
        thirtyMiles = (Button) findViewById(R.id.thirtyMiles);
        fiftyMiles = (Button) findViewById(R.id.fiftyMiles);


        fifteenMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mileRadius = 15;
                openStorePicker();
            }
        });
        thirtyMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mileRadius = 30;
                openStorePicker();
            }
        });
        fiftyMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mileRadius = 50;
                openStorePicker();
            }
        });
    }
    public void openStorePicker() {
        Intent openStore = new Intent(this, StorePicker.class);
        openStore.putExtra(EXTRA_NUM, mileRadius);
        startActivity(openStore);
    }

    //We'll start here tomorrow!
    //WOOOOO

}
