package com.example.projet_eq2_desjim.admin.ajouter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;
import com.example.projet_eq2_desjim.admin.listes.ListeEtudiantsActivity;

import Metier.Etudiant;

public class AjouterEtudiantActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ajouteretudiant);



        Button btnAjouter = (Button) findViewById(R.id.button4);
        Button btnAnnuler = (Button) findViewById(R.id.button5);


        bdd.bddDAO clientBdd = new bdd.bddDAO(this);

        //on ouvre la base de données
        clientBdd.open();

        View.OnClickListener ecouteur = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button4:

                        Etudiant unEtudiant = new Etudiant(

                                ((TextView)findViewById(R.id.editTextTextPersonName3)).getText().toString(),

                                ((TextView)findViewById(R.id.editTextTextPersonName4)).getText().toString(),

                                ( (TextView)findViewById(R.id.editTextTextPersonName16)).getText().toString(),
                                Integer.parseInt(((TextView) findViewById(R.id.editTextTextPersonName21)).getText().toString()));

                        clientBdd.insererEtudiant(unEtudiant);

                        startActivity(new Intent(AjouterEtudiantActivity.this, ListeEtudiantsActivity.class));

                        Toast.makeText(getApplicationContext(), "L'étudiant(e) " + unEtudiant.getPrenom() + " " + unEtudiant.getNom() + " a bien été ajouté(e).", Toast.LENGTH_LONG).show();

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
