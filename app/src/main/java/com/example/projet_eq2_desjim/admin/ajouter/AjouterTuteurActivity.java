package com.example.projet_eq2_desjim.admin.ajouter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;
import com.example.projet_eq2_desjim.admin.listes.ListeProfesseursActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeTuteursActivity;

import Metier.Entreprise;
import Metier.Tuteur;
import Metier.Visite;
import bdd.bddDAO;

public class AjouterTuteurActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ajoutertuteur);

        Button btnAjouter = (Button) findViewById(R.id.button4);
        Button btnAnnuler = (Button) findViewById(R.id.button5);

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

        View.OnClickListener ecouteur = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button4:

                        Cursor c = NvBdd.getDataEntrepriseByNom(String.valueOf(spinnerEntreprise.getSelectedItem()));

                        Entreprise entreprise = NvBdd.cursorToEntreprise(c);


                        Tuteur unTuteur = new Tuteur(

                                entreprise.getId(),

                                ((TextView)findViewById(R.id.editTextTextPersonName3)).getText().toString(),

                                ((TextView)findViewById(R.id.editTextTextPersonName4)).getText().toString(),

                                ((TextView)findViewById(R.id.editTextTextPersonName16)).getText().toString(),

                                ( (TextView)findViewById(R.id.editTextTextPersonName21)).getText().toString());

                        NvBdd.insererTuteur(unTuteur);

                        startActivity(new Intent(AjouterTuteurActivity.this, ListeTuteursActivity.class));

                        Toast.makeText(getApplicationContext(), "Le tuteur " +  unTuteur.getPrenom() + " " + unTuteur.getNom() + " a bien été ajouté.", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button5:
                        finish();
                        break;
                }
            }
        };

        btnAjouter.setOnClickListener(ecouteur);
        btnAnnuler.setOnClickListener(ecouteur);

    }
}