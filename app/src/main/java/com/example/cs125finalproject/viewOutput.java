package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class viewOutput extends AppCompatActivity {

    public int mileRadius;
    public ArrayList<String> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_output);

        Intent getIntent = getIntent();
        mileRadius = getIntent.getIntExtra(StorePicker.EXTRA_NUM,0);
        locationList = getIntent.getStringArrayListExtra(StorePicker.EXTRA_STRING_ARRAY);

        TextView outputText = findViewById(R.id.ouptutText);
        outputText.setText(Store.outputString(locationList, mileRadius));



    }

}
