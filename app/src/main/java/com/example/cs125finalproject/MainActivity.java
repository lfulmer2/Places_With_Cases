package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        private String test = "this is a test variable";
        System.out.println(test);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
