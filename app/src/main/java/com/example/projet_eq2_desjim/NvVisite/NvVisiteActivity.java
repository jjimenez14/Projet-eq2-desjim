package com.example.projet_eq2_desjim.NvVisite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;

import java.util.ArrayList;

import bdd.bddDAO;



public class NvVisiteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nvlvisite);
        final String[] leCompteur = new String[1];
        final String[] leCompteur2 = new String[1];
        final String[] leCompteur3 = new String[1];
        final String[] leCompteur4 = new String[1];

        Button btnSuivant = (Button) findViewById(R.id.button4);
        Button btnPrecedent = (Button) findViewById(R.id.button5);
        View.OnClickListener ecouteur = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button4:
                        startActivity(new Intent(NvVisiteActivity.this, NvVisiteActivity2.class));
                        break;
                    case R.id.button5:
                        finish();
                }
            }
        };

        btnSuivant.setOnClickListener(ecouteur);
        btnPrecedent.setOnClickListener(ecouteur);
        bddDAO NvBdd = new bddDAO(this);
        NvBdd.open();
//--------------------------------------------------------------------------------------------------

    //gestion de la liste déroulante des numéros de compteur
    final Spinner spinnerEtudiant = (Spinner) findViewById(R.id.spinner3);
    Cursor c = NvBdd.getDataEtudiant();
    String[] lesEtudiants = bddDAO.cursorToEtudiant2(c);

    ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesEtudiants);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEtudiant.setAdapter(dataAdapterR);
        spinnerEtudiant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                leCompteur[0] = String.valueOf(spinnerEtudiant.getSelectedItem());


            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){

            }
        });


//--------------------------------------------------------------------------------------------------

    //gestion de la liste déroulante des numéros de compteur
    final Spinner spinnerProfesseur = (Spinner) findViewById(R.id.spinner);
    Cursor c2 = NvBdd.getDataProfesseur();
    String[] lesProfesseurs = bddDAO.cursorToProfesseur2(c2);

    ArrayAdapter<String> dataAdapterR2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesProfesseurs);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProfesseur.setAdapter(dataAdapterR2);
        spinnerProfesseur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                leCompteur2[0] = String.valueOf(spinnerProfesseur.getSelectedItem());


            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){

            }
        });

//--------------------------------------------------------------------------------------------------

    //gestion de la liste déroulante des numéros de compteur
    final Spinner spinnerTuteur = (Spinner) findViewById(R.id.spinner2);
    Cursor c3 = NvBdd.getDataTuteur();
    String[] lesTuteurs = bddDAO.cursorToTuteur2(c3);

    ArrayAdapter<String> dataAdapterR3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesTuteurs);
    dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerTuteur.setAdapter(dataAdapterR3);
    spinnerTuteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                leCompteur3[0] = String.valueOf(spinnerTuteur.getSelectedItem());


            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){

            }
        });

//--------------------------------------------------------------------------------------------------
    //gestion de la liste déroulante des numéros de compteur
    final Spinner spinnerEntreprise = (Spinner) findViewById(R.id.spinner4);
    Cursor c4 = NvBdd.getDataEntreprise();
    String[] lesEntreprises = bddDAO.cursorToEntreprise2(c4);

    ArrayAdapter<String> dataAdapterR4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesEntreprises);
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEntreprise.setAdapter(dataAdapterR4);
        spinnerEntreprise.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                leCompteur4[0] = String.valueOf(spinnerEntreprise.getSelectedItem());


            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){

            }
        });

//--------------------------------------------------------------------------------------------------

    NvBdd.close();

    }




}
