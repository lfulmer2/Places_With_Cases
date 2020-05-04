package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class StorePicker extends AppCompatActivity {

    private Button continueButton;
    private CheckBox saveALot, aldi, countyMarket, walmartSupercenter;
    public boolean saveALotChosen = false;
    public boolean aldiChosen = false;
    public boolean countyMarketChosen = false;
    public boolean walmartSupercenterChosen = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store__picker);


        continueButton = (Button) findViewById(R.id.continueButton);
        saveALot = (CheckBox) findViewById(R.id.saveALotCheck);
        aldi = (CheckBox) findViewById(R.id.aldiCheck);
        countyMarket = (CheckBox) findViewById(R.id.countyMarketCheck);
        walmartSupercenter = (CheckBox) findViewById(R.id.walmartSupercenterCehck);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!saveALot.isChecked() && !aldi.isChecked() && !countyMarket.isChecked()) {
                    Toast.makeText(StorePicker.this, "Error: You did not choose a store, please select one.", Toast.LENGTH_LONG).show();
                    return;
                }
                if (saveALot.isChecked()) {
                    saveALotChosen = true;
                }
                if (aldi.isChecked()) {
                    aldiChosen = true;
                }
                if (countyMarket.isChecked()) {
                    countyMarketChosen = true;
                }
                if (walmartSupercenter.isChecked()) {
                    walmartSupercenterChosen = true;
                }
                openViewOutput();
            }
        });
    }
    public void openViewOutput() {
        Intent openView = new Intent(this, viewOutput.class);
        startActivity(openView);
    }
}
