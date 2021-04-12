package com.example.projet_eq2_desjim.ListeVisites;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import bdd.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;

import java.util.HashMap;

public class ListeVisitesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listevisite);

            bddDAO DaoVisite = new bddDAO(this);

            ListView listViewVisite = findViewById(R.id.listvisite);

            DaoVisite.open();

            Cursor c = DaoVisite.getInfoForTab();

            // colonnes à afficher
            String[] columns = new String[]{bddDAO.COL_ID_VISITE, bddDAO.COL_NOM_ETUDIANT, bddDAO.COL_NOM_TUTEUR, bddDAO.COL_NOM_PROFESSEUR, bddDAO.COL_DATE_VISITE};

            // champs dans lesquelles afficher les colonnes
            int[] to = new int[]{R.id.textIdVisite, R.id.textNomEtudiant, R.id.textNomTuteur, R.id.textNomProf, R.id.textDate};

            //on choisit le type d’adapter pour notre affichage de la liste
            SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.layout_listevisite, c, columns, to, 0);

            // on assigne cet adapter à notre ListView
            listViewVisite.setAdapter(dataAdapter);

            //on ferme la table
            DaoVisite.close();


        listViewVisite.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               listViewVisite.getItemAtPosition(position);



                Intent intent = new Intent(ListeVisitesActivity.this,InfosVisiteActivity.class);
                intent.putExtra("IdVisite", position);
                startActivityForResult(intent, 0);
            }
        });


        }




    }

