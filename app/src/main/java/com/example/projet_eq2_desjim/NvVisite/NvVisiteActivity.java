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


    //gestion de la liste déroulante des numéros de compteur
    final Spinner spinnerEtudiant = (Spinner) findViewById(R.id.spinner3);
    bddDAO EtudiantBdd = new bddDAO(this);
    EtudiantBdd.open();

    Cursor c = EtudiantBdd.getDataEtudiant();
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
    EtudiantBdd.close();

    }




}
