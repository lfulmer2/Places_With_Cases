package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StorePicker extends AppCompatActivity {

    public static final String EXTRA_STRING_ARRAY = "com.example.cs125finalproject.EXTRA_STRING_ARRAY";
    public static final String EXTRA_NUM = "com.example.cs125finalproject.EXTRA_NUM";

    private Button continueButton;
    private CheckBox saveALot, aldi, countyMarket, walmartSupercenter;
    public boolean saveALotChosen = false;
    public boolean aldiChosen = false;
    public boolean countyMarketChosen = false;
    public boolean walmartSupercenterChosen = false;
    public int mileRadius;
    public ArrayList<String> locationList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store__picker);

        Intent getIntent = getIntent();
        mileRadius = getIntent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        continueButton = findViewById(R.id.continueButton);
        saveALot = findViewById(R.id.saveALotCheck);
        aldi = findViewById(R.id.aldiCheck);
        countyMarket = findViewById(R.id.countyMarketCheck);
        walmartSupercenter = findViewById(R.id.walmartSupercenterCehck);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!saveALot.isChecked() && !aldi.isChecked() && !countyMarket.isChecked() && !walmartSupercenter.isChecked()) {
                    Toast.makeText(StorePicker.this, "Error: You did not choose a store, please select one.", Toast.LENGTH_LONG).show();
                    return;
                }
                if (saveALot.isChecked()) {
                    saveALotChosen = true;
                    locationList.add("Save-a-lot");
                }
                if (aldi.isChecked()) {
                    aldiChosen = true;
                    locationList.add("ALDI");
                }
                if (countyMarket.isChecked()) {
                    countyMarketChosen = true;
                    locationList.add("County Market");
                }
                if (walmartSupercenter.isChecked()) {
                    walmartSupercenterChosen = true;
                    locationList.add("Walmart Supercenter");
                }
                openViewOutput();
            }
        });
    }
    public void openViewOutput() {
        Intent openView = new Intent(this, viewOutput.class);
        openView.putStringArrayListExtra(EXTRA_STRING_ARRAY, locationList);
        openView.putExtra(EXTRA_NUM, mileRadius);
        startActivity(openView);
    }


}
