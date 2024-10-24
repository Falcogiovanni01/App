package com.example.gym;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gym.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        public static ArrayList<LoginUser> login = new ArrayList<>() ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_main);

                // Trova il campo di input per il nome utente
                TextInputEditText usernameEditText = findViewById(R.id.username_edit_text); // Assicurati che l'ID corrisponda
                TextInputEditText passwordEdit = findViewById(R.id.password_edit_text);


                // next_button
                // VOGLIOO METTERMI IN ASCOLTO SU BUTTON, DEVO USARE LE VIEW :
                Button buttonNext = findViewById(R.id.next_button);
                // pescato il bottone mi metto in ascolto :
                buttonNext.setOnClickListener((View view) -> {
                        // Crea un Intent per avviare WelcomeActivity
                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);

                        // Aggiungi parametri all'Intent
                        String username =  usernameEditText.getText().toString().trim(); // Sostituisci con il valore che desideri passare
                        String pass =  passwordEdit.getText().toString().trim();

                        LoginUser user = new LoginUser(username ,pass );
                        login.add(new LoginUser("giovanni","prova1000"));
                        login.add(new LoginUser("michele","prova1000"));

                        intent.putExtra("username_key", username);
                        // VERIFICHIAMO SE L'UTENTE ESISTE :
                        if(login.contains(user)== true ){
                                // entra
                                startActivity(intent);
                        }else {
                                //DOVE VAI ?? non sei loggato
                                Toast.makeText(MainActivity.this, "Credenziali non valide", Toast.LENGTH_SHORT).show();
                        }

                        // REGISTRAZIONE
                        TextView registerLink = findViewById(R.id.register_link);
                        registerLink.setOnClickListener((View view1)-> {

                                        // Crea un Intent per avviare la RegistrationActivity
                                        Intent intent1 = new Intent(MainActivity.this, SignUp.class);
                                        startActivity(intent1); // Avvia l'activity di registrazione

                        });
                       // Avvia l'activity
                });
                /**
                 * CONTACT ME :
                 */
                MaterialToolbar toolbar = findViewById(R.id.contactMe);
                toolbar.setNavigationOnClickListener(
                        new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        showPopup();
                              }
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

        public static boolean isPasswordValid(Editable text) {
                boolean open =false ;
                if(text.length()< 8){
                        open= false ;
                } else{
                        open = true ;
                }
                return open;
        }

        /**
         * POPUP
         */
        private void showPopup() {
                // Crea un nuovo Dialog
                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.popup); // Imposta il layout del dialog

                // Trova le TextView e imposta i listener per i clic
                TextView linkedinLink = dialog.findViewById(R.id.linkedin_link);
                TextView githubLink = dialog.findViewById(R.id.github_link);
                TextView instagramLink = dialog.findViewById(R.id.instagram_link);

                linkedinLink.setOnClickListener(new View.OnClickListener()  {
                        @Override
                        public void onClick(View v) {
                                openLink("https://www.linkedin.com/feed/");
                                dialog.dismiss(); // Chiudi il dialog
                        }
                });

                githubLink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                openLink("https://github.com/Falcogiovanni01");
                                dialog.dismiss();
                        }
                });

                instagramLink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                openLink("https://www.instagram.com/f.gio_/profilecard/?igsh=MXJ6MHcwaHdsZjNsZA%3D%3D"); // Sostituisci con il tuo link
                                dialog.dismiss(); // Chiudi il dialog
                        }
                });

                dialog.show(); // Mostra il dialog
        }

        private void openLink(String url) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent); // Apri il link nel browser
        }



}