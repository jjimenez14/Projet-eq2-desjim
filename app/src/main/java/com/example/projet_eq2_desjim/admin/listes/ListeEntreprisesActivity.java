package com.example.projet_eq2_desjim.admin.listes;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;

import bdd.bddDAO;

public class ListeEntreprisesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listeentreprises);

        bddDAO DaoEntreprises = new bddDAO(this);

        ListView listViewEtudiants = findViewById(R.id.listeleves);

        DaoEntreprises.open();

        Cursor c = DaoEntreprises.getDataEntreprise();

        // colonnes à afficher
        String[] columns = new String[]{bddDAO.COL_ID_ENTREPRISE, bddDAO.COL_NOM_ENTREPRISE, bddDAO.COL_ADRESSE_ENTREPRISE, bddDAO.COL_NUMTEL_ENTREPRISE};

        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.textView2, R.id.textView6, R.id.textView7, R.id.textView8};

        //on choisit le type d’adapter pour notre affichage de la liste
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.layout_listeetudiants, c, columns, to, 0);

        // on assigne cet adapter à notre ListView
        listViewEtudiants.setAdapter(dataAdapter);

        //on ferme la table
        DaoEntreprises.close();

    }
}
