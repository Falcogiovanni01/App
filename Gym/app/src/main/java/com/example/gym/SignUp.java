package com.example.gym;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {
    // QUI AVVIENE LA REGISTRAZIONE DELL'UTENTE.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.signup);
        // CREO DUE BOTTONI, SIGN UP E DELETE
        Button signup = findViewById(R.id.signUp_button);
        Button delete = findViewById(R.id.signup_cancel_button);

        signup.setOnClickListener((View view )->{
            // PRENDO I CAMPIO CHE MI INTERESSANO :
            EditText usernameEditText = findViewById(R.id.signUpName); // Assicurati che l'ID corrisponda
            EditText passwordEdit = findViewById(R.id.editTextPasswordSignUp);
            Editable passCheck = passwordEdit.getText(); // Otteniamo l'Editable per il controllo

            String username =  usernameEditText.getText().toString().trim(); // Sostituisci con il valore che desideri passare
        String pass =  passwordEdit.getText().toString().trim();
        if(!username.isEmpty()  && MainActivity.isPasswordValid(passCheck)) {
                LoginUser user = new LoginUser(username, pass);
                MainActivity.login.add(user);
                Intent intent = new Intent(SignUp.this, WelcomeActivity.class);
                startActivity(intent);
            }


        });

        delete.setOnClickListener( (View view)->{
            // Pulisci i campi di input
            EditText usernameEditText = findViewById(R.id.signUpName);
            EditText passwordEdit = findViewById(R.id.editTextPasswordSignUp);
            EditText emailEdit = findViewById(R.id.editTextEmail);

            usernameEditText.setText(""); // Pulisce il campo nome
            passwordEdit.setText(""); // Pulisce il campo password
            emailEdit.setText("");
        });



    }

}
