package com.example.myapplicationjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ViewUpper extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_animal);

    }
}
