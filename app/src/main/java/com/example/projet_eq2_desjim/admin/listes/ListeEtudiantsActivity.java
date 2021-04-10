package com.example.projet_eq2_desjim.admin.listes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;
import com.example.projet_eq2_desjim.admin.menu.AdminMenuActivity;
import com.example.projet_eq2_desjim.admin.ajouter.AjouterEtudiantActivity;

import bdd.bddDAO;

public class ListeEtudiantsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listeetudiants);

        bddDAO DaoEtudiants = new bddDAO(this);

        ListView listViewEtudiants = findViewById(R.id.listeleves);

        DaoEtudiants.open();

        Cursor c = DaoEtudiants.getDataEtudiant();

        // colonnes à afficher
        String[] columns = new String[]{bddDAO.COL_ID_ETUDIANT, bddDAO.COL_NOM_ETUDIANT, bddDAO.COL_PRENOM_ETUDIANT, bddDAO.COL_CLASSE_ETUDIANT, bddDAO.COL_ANNEE_ETUDIANT};

        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.textView2, R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9};

        //on choisit le type d’adapter pour notre affichage de la liste
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.layout_listeetudiants, c, columns, to, 0);

        // on assigne cet adapter à notre ListView
        listViewEtudiants.setAdapter(dataAdapter);

        //on ferme la table
        DaoEtudiants.close();

        Button btnAjouter = (Button) findViewById(R.id.button4);
        Button btnAnnuler = (Button) findViewById(R.id.button5);


        View.OnClickListener ecouteur = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button4:
                        startActivity(new Intent(ListeEtudiantsActivity.this, AjouterEtudiantActivity.class));
                        break;
                    case R.id.button5:
                        startActivity(new Intent(ListeEtudiantsActivity.this, AdminMenuActivity.class));
                        break;
                }
            }
        };

        btnAjouter.setOnClickListener(ecouteur);
        btnAnnuler.setOnClickListener(ecouteur);
    }
}