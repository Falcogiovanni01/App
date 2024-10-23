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

        private boolean isPasswordValid(Editable text) {
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
                                openLink("https://www.linkedin.com/feed/"); // Sostituisci con il tuo link
                                dialog.dismiss(); // Chiudi il dialog
                        }
                });

                githubLink.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                openLink("https://github.com/Falcogiovanni01"); // Sostituisci con il tuo link
                                dialog.dismiss(); // Chiudi il dialog
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