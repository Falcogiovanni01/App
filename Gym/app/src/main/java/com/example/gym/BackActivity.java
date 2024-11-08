package com.example.gym;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class BackActivity  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_back);

        // questo è presente in activity view back ,
        ListView listView = findViewById(R.id.myListView);

        ArrayList<listBack> item = new ArrayList<>();

        // ora aggiungo gli elementi
        item.add(new listBack(getDrawable(R.drawable.latmachinedautilizzare), getString(R.string.LatMachinT), getString(R.string.LatMachinDescription)));

        item.add(new listBack(getDrawable(R.drawable.tbar), getString(R.string.T_bar), getString(R.string.TBarDescription)));

        item.add(new listBack(getDrawable(R.drawable.pulley), getString(R.string.PulleyT), getString(R.string.PulleyDescription)));

        // Crea l'adapter e passagli la lista
        ListBackAdapter adapter = new ListBackAdapter(this, item);

        // Imposta l'adapter sulla ListView
        listView.setAdapter(adapter);


        MaterialToolbar toolbar = findViewById(R.id.topAppBarBACK);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(BackActivity.this,MainActivity.class);
             startActivity(intent);
            }
        });

    }
}
