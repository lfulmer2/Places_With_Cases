package com.example.cs125finalproject;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Covid {
    private RequestQueue mQueue;

    // Referred to the following site https://www.youtube.com/watch?v=y2xtLqP8dSQ for producing this code

    public Map<String,Integer> jsonParseCovidCases(Context context) {
        final Map<String, Integer> casesPerCounty = new HashMap<>();

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
                    Store.initialize(casesPerCounty);

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

}



