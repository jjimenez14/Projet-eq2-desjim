package com.example.projet_eq2_desjim.admin.ajouter;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;

import bdd.bddDAO;

public class AjouterTuteurActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ajoutertuteur);

        final String[] leCompteur = new String[1];

        bddDAO NvBdd = new bddDAO(this);
        NvBdd.open();

        //gestion de la liste déroulante des numéros de compteur
        final Spinner spinnerEntreprise = (Spinner) findViewById(R.id.spinner5);
        Cursor c4 = NvBdd.getDataEntreprise();
        String[] lesEntreprises = bddDAO.cursorToEntreprise2(c4);

        ArrayAdapter<String> dataAdapterR4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesEntreprises);
        dataAdapterR4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEntreprise.setAdapter(dataAdapterR4);
        spinnerEntreprise.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                leCompteur[0] = String.valueOf(spinnerEntreprise.getSelectedItem());


            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){

            }
        });

        NvBdd.close();

    }
}