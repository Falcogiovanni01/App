package com.example.gym;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ListBackAdapter extends BaseAdapter {
    private Context context; // per le view

    private ArrayList<listBack> trainBack ;

    public ListBackAdapter(Context context, ArrayList<listBack> items) {
        this.context = context;
        this.trainBack = items;
    }

    // essendo un adapter devi implementare le sue funzioni :
    @Override
    public int getCount() {
        // Restituisci il numero di elementi nella lista
        return trainBack.size();
    }

    @Override
    public Object getItem(int position) {
        // Restituisci l'elemento alla posizione specifica
        return trainBack.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Restituisci un ID unico per l'elemento
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Crea o riutilizza una vista per ogni elemento della lista
        // Inflater per creare o riutilizzare la vista
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.back_adapter_layout, parent, false);
        }

        // Ottieni il riferimento all'oggetto listBack alla posizione corrente
        listBack currentItem = trainBack.get(position);

        // Inizializza le view e assegna i valori
        ImageView imageView = convertView.findViewById(R.id.ImageBACK);
        TextView titleView = convertView.findViewById(R.id.TitleBACK);
        TextView descriptionView = convertView.findViewById(R.id.textBACK);

        // Imposta i dati nella vista
        imageView.setImageDrawable(currentItem.getImage()); // verifica che l'immagine sia compatibile con questo metodo
        titleView.setText(currentItem.getTitle());
        descriptionView.setText(currentItem.getDescription());

        // Gestisci il clic sull'immagine
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof AppCompatActivity) {
                    // Mostra il DialogFragment usando il FragmentManager dell'Activity
                    BlankFragment blankFragment = new BlankFragment();
                    blankFragment.show(
                            ((AppCompatActivity) context).getSupportFragmentManager(), BlankFragment.TAG);
                }
            }
        });


        return convertView;
    }

    private void openFragment() {
        // Ottieni il FragmentManager
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        // Crea una nuova istanza del Fragment
        BackFragment fragment = new BackFragment();
        // Aggiungi il Fragment alla transazione
        transaction.replace(R.id.fragment1, fragment);
        transaction.addToBackStack(null); // Aggiungi al back stack per poter tornare indietro
        // Esegui la transazione
        transaction.commit();
    }

}
