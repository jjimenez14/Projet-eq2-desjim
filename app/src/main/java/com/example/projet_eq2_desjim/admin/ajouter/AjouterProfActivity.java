package com.example.projet_eq2_desjim.admin.ajouter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;
import com.example.projet_eq2_desjim.admin.listes.ListeEntreprisesActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeProfesseursActivity;

import Metier.Professeur;

public class AjouterProfActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ajouterprof);


        Button btnAjouter = (Button) findViewById(R.id.button4);
        Button btnAnnuler = (Button) findViewById(R.id.button5);


        bdd.bddDAO clientBdd = new bdd.bddDAO(this);

        //on ouvre la base de données
        clientBdd.open();

        View.OnClickListener ecouteur = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button4:

                        Professeur unProf = new Professeur(

                                ((TextView)findViewById(R.id.editTextTextPersonName3)).getText().toString(),

                                ((TextView)findViewById(R.id.editTextTextPersonName4)).getText().toString(),

                                ((TextView)findViewById(R.id.editTextTextPersonName16)).getText().toString(),

                                ( (TextView)findViewById(R.id.editTextTextPersonName21)).getText().toString());

                        clientBdd.insererProfesseur(unProf);

                        startActivity(new Intent(AjouterProfActivity.this, ListeProfesseursActivity.class));

                        Toast.makeText(getApplicationContext(), "Le professeur " +  unProf.getPrenom() + " " + unProf.getNom() + " a bien été ajouté.", Toast.LENGTH_LONG).show();

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
