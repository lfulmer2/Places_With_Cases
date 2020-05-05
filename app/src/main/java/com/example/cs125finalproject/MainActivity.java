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
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUM = "com.example.cs125finalproject.EXTRA_NUM";

    private Button fifteenMiles;
    private Button thirtyMiles;
    private Button fiftyMiles;
    public int mileRadius;
    public HashMap<String,Integer> casesPerCounty;
    private RequestQueue mQueue;


    public Map<String,Integer> jsonParseCovidCases(Context context) {
        mQueue = Volley.newRequestQueue(context);

        String url = "https://www.dph.illinois.gov/sitefiles/COVIDTestResults.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener< JSONObject >() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject characteristics_by_county = response.getJSONObject("characteristics_by_county");
                    JSONArray jsonArray = characteristics_by_county.getJSONArray("values");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject covidCases = jsonArray.getJSONObject(i);
                        String countyName = covidCases.getString("County");
                        int numCases = covidCases.getInt("confirmed_cases");
                        casesPerCounty.put(countyName, numCases);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        // Add the request to the RequestQueue.
        mQueue.add(request);
        return casesPerCounty;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fifteenMiles = (Button) findViewById(R.id.fifteenMiles);
        thirtyMiles = (Button) findViewById(R.id.thirtyMiles);
        fiftyMiles = (Button) findViewById(R.id.fiftyMiles);



        Map<String, Integer> cases = jsonParseCovidCases(this);
        Store.initialize(cases);

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



}
