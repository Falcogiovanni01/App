package com.example.gym;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.gym.R;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    private Toolbar myToolbar; // Dichiarazione della Toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Imposta il layout per questa activity

        myToolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(myToolbar);


        // Recupera l'Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username_key");

        // Trova il TextView per il nome utente
        TextView usernameTextView = findViewById(R.id.username_text_view);

        // Imposta il nome utente
        usernameTextView.setText(username);


        Button buttonBack = findViewById(R.id.welcome_button_back);
        buttonBack.setOnClickListener((View view) -> {
            Intent portamiIndietro = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(portamiIndietro);
        });

        // facciamo apparire allenati e dieta , da li apriamo due fragment che fanno qualcosa :
//        ListView listView = findViewById(R.id.myListViewWelcome);
//
//        ArrayList<listBack> item = new ArrayList<>();
//
//        // ora aggiungo gli elementi
//        item.add(new listBack(getDrawable(R.drawable.allenati_con_noi), " Allenati con noi ", ""));
//
//        item.add(new listBack(getDrawable(R.drawable.dieta), " dieta bilanciata adatta per te", ""));
//
//
//        // Crea l'adapter e passagli la lista
//        ListBackAdapter adapter = new ListBackAdapter(this, item);
//
//        // Imposta l'adapter sulla ListView
//        listView.setAdapter(adapter);
//

    }

    // Questo metodo deve stare fuori da onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Anche questo metodo deve essere fuori da onCreate
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.viewAnimal) {
            Intent intent = new Intent(WelcomeActivity.this, ViewUpper.class);
            startActivity(intent);
//            Intent portamiIndietro = new Intent(WelcomeActivity.this, MainActivity.class);
//            startActivity(portamiIndietro);

            return true;
        } else if (id ==  R.id.another) {

            Intent intent = new Intent(WelcomeActivity.this, BackActivity.class);
            startActivity(intent);

            return true;
        } else if(id == R.id.viewlower){
            Toast.makeText(getApplicationContext(),"Item 2 Selected", Toast.LENGTH_LONG).show();
            return true ;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }
}
