package com.example.projet_eq2_desjim.NvVisite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;

import Metier.Entreprise;
import Metier.Etudiant;
import Metier.Professeur;
import Metier.Tuteur;
import bdd.bddDAO;

public class NvVisiteActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nvlvisite3);

        Intent intent2 = getIntent();
            String etudiant = intent2.getStringExtra("etudiant");
        String professeur = intent2.getStringExtra("prof");
        String tuteur = intent2.getStringExtra("tuteur");
        String entreprise = intent2.getStringExtra("entreprise");


        Button btnSuivant = (Button) findViewById(R.id.button4);
        Button btnPrecedent = (Button) findViewById(R.id.button5);

        TextView TextViewDate =  findViewById(R.id.editTextTextPersonName2);
        TextView TextViewConditions =  findViewById(R.id.editTextTextMultiLine);
        TextView TextViewBilan =  findViewById(R.id.editTextTextMultiLine2);
        TextView TextViewRessources =  findViewById(R.id.editTextTextMultiLine3);
        TextView TextViewCommentaires =  findViewById(R.id.editTextTextMultiLine4);

        bddDAO NvBdd = new bddDAO(this);
        NvBdd.open();

        String zeEtudiant[] = etudiant.split(" ");
        Etudiant leEtudiant = NvBdd.cursorToEtudiant(NvBdd.getDataEtudiantByNom(zeEtudiant[1]));

        String zeProf[] = professeur.split(" ");
        Professeur leProf = NvBdd.cursorToProfesseur(NvBdd.getDataProfesseurByNom(zeProf[1]));


        Entreprise laEntreprise = NvBdd.cursorToEntreprise(NvBdd.getDataEntrepriseByNom(entreprise));

        String zeTuteur[] = tuteur.split(" ");
        Tuteur leTuteur = NvBdd.cursorToTuteur(NvBdd.getDataTuteurByNom(zeTuteur[1]));



        View.OnClickListener ecouteur = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()) {
                    case R.id.button4:

                        Intent intent = new Intent(NvVisiteActivity3.this, NvVisiteActivity4.class);

                        String date = String.valueOf(TextViewDate.getText());
                        String conditions = String.valueOf(TextViewConditions.getText());
                        String bilan = String.valueOf(TextViewBilan.getText());
                        String ressources = String.valueOf(TextViewRessources.getText());
                        String commentaires = String.valueOf(TextViewCommentaires.getText());

                        intent.putExtra("etudiant", leEtudiant.getId());
                        intent.putExtra("prof", leProf.getId());
                        intent.putExtra("tuteur", leTuteur.getId());

                        intent.putExtra("date",date);
                        intent.putExtra("conditions",conditions);
                        intent.putExtra("bilan",bilan);
                        intent.putExtra("ressources",ressources);
                        intent.putExtra("commentaires",commentaires);

                        startActivityForResult(intent, 0);

                        break;
                    case R.id.button5:
                        finish();
                }
            }
        };

        btnSuivant.setOnClickListener(ecouteur);
        btnPrecedent.setOnClickListener(ecouteur);
    }
}
