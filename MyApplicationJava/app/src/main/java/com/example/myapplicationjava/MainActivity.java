package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        // next_button
        // VOGLIOO METTERMI IN ASCOLTO SU BUTTON, DEVO USARE LE VIEW :
        Button buttonNext = findViewById(R.id.next_button);
        // pescato il bottone mi metto in ascolto :
        buttonNext.setOnClickListener((View view) -> {
            // Crea un Intent per avviare WelcomeActivity
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent); // Avvia l'activity

        });

        // VOGLIO MONITORARE LA PASSWORD :
        TextInputLayout passwordTextInput = findViewById(R.id.password_text_input);
        TextInputEditText passwordEditText = findViewById(R.id.password_edit_text);

        // VUOLE UN TEXT WATCHER COME PARAMETRO.
        // Clear the error once more than 8 characters are typed.
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Non necessario qui
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Non necessario qui
            }

            @Override // durante la scrittura si "attiva questa funzione"
            public void afterTextChanged(Editable s) {
                // Controlla la validità della password
                if (isPasswordValid(s)) {
                    passwordTextInput.setError(null); // Rimuovi l'errore
                    buttonNext.setEnabled(true); // Abilita il pulsante
                } else {
                    passwordTextInput.setError("La password deve contenere almeno 8 caratteri."); // Imposta l'errore
                    buttonNext.setEnabled(false); // Disabilita il pulsante
                }
            }
        });


    }

    private boolean isPasswordValid(Editable text) {
        boolean open =false ;
        if(text.length()< 8){
            open= false ;
        } else{
            open = true ;
        }
        return open;
    }
}