package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ViewUpper extends AppCompatActivity {

    private Toolbar myToolbar; // Dichiarazione della Toolbar


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upper);

        // SET TOOL BAR :
        myToolbar = findViewById(R.id.topAppBarUpper);
        setSupportActionBar(myToolbar);

        setupClickableTitles();

    }
    /***
     * VISIBILITY DESCRIPTION
     */
    private void setupClickableTitles() {
        // Imposta il titolo e la descrizione per Panca Piana
        TextView titlePancaPiana = findViewById(R.id.titlePancaBilanciere);
        final TextView descriptionPancaPiana = findViewById(R.id.descriptionPancaBilanciere);

        titlePancaPiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (descriptionPancaPiana.getVisibility() == View.GONE) {
                    descriptionPancaPiana.setVisibility(View.VISIBLE); // rende visibile l'elemento
                } else {
                    descriptionPancaPiana.setVisibility(View.GONE);
                }
            }
        });

        // Ripeti per Chest Press e Panca Piana Manubri
        TextView titleChestPress = findViewById(R.id.titleChest);
        final TextView descriptionChestPress = findViewById(R.id.descriptionChest);

        titleChestPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (descriptionChestPress.getVisibility() == View.GONE) {
                    descriptionChestPress.setVisibility(View.VISIBLE);
                } else {
                    descriptionChestPress.setVisibility(View.GONE);
                }
            }
        });

        // Esegui lo stesso per Panca Piana Manubri...
        TextView titlePancaManubri = findViewById(R.id.titlePancaManubri);
        final TextView descriptionPancaManubri = findViewById(R.id.descriptionPancaManubri);

        titlePancaManubri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (descriptionPancaManubri.getVisibility() == View.GONE) {
                    descriptionPancaManubri.setVisibility(View.VISIBLE); // rende visibile l'elemento
                } else {
                    descriptionPancaManubri.setVisibility(View.GONE);
                }
            }
        });

    }





    /****
     * MENU
     */
    // Questo metodo deve stare fuori da onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_upper, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Anche questo metodo deve essere fuori da onCreate
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.back) {
            Intent intent = new Intent(ViewUpper.this, WelcomeActivity.class);
            startActivity(intent);
//            Intent portamiIndietro = new Intent(WelcomeActivity.this, MainActivity.class);
//            startActivity(portamiIndietro);

            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }



}
