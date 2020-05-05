package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button fifteenMiles;
    private Button thirtyMiles;
    private Button fiftyMiles;
    public int mileRadius;
    public HashMap<String,Integer> casesPerCounty;
    private RequestQueue mQueue;


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

        Covid covidData = new Covid();
        Map<String, Integer> cases = covidData.jsonParseCovidCases(this);
        Store.initialize(cases);
    }

    public void openStorePicker() {
        Intent openStore = new Intent(this, StorePicker.class);
        startActivity(openStore);
    }



}
