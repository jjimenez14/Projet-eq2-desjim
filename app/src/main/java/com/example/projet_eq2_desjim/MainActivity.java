package com.example.projet_eq2_desjim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.projet_eq2_desjim.NvVisite.NvVisiteActivity;
import com.example.projet_eq2_desjim.admin.AdminMenuActivity;

import bdd.*;
import Metier.*;

public class MainActivity extends AppCompatActivity {

    public void remplirTableEtudiant() {
        bddDAO etudiantBdd = new bddDAO(this);
        Etudiant etudiant1 = new Etudiant(1,"Carlier","Jules","SEGPA", 2);
        Etudiant etudiant2 = new Etudiant(2,"Desmonceaux","Baptiste","SEGPA", 2);
        Etudiant etudiant3 = new Etudiant(3,"Jimenez","Julian","SEGPA", 2);

        //on ouvre la base de données
        etudiantBdd.open();
        //on insère etudiant1
        etudiantBdd.insererEtudiant(etudiant1);
        etudiantBdd.insererEtudiant(etudiant2);
        etudiantBdd.insererEtudiant(etudiant3);

        //le curseur pour afficher le nombre d'étudiant dans la base
        Cursor c = etudiantBdd.getDataEtudiant();
        System.out.println("Il y a " + String.valueOf(c.getCount()) + " étudiant(s)");
        String[] lesEtudiants = bddDAO.cursorToEtudiant2(c);

        for(int i=0; i < lesEtudiants.length; i++) {
            System.out.println(lesEtudiants[i]);
        }
    }

    public void remplirTableEntreprise() {
        bddDAO entrepriseBdd = new bddDAO(this);
        Entreprise entreprise1 = new Entreprise(1,"Chlorophylle","5 boulevard du zinzolin","0645857478");

        //on ouvre la base de données
        entrepriseBdd.open();
        //on insère entreprise1
        entrepriseBdd.insererEntreprise(entreprise1);

        //le curseur pour afficher le nombre d'entreprise dans la base
        Cursor c = entrepriseBdd.getDataEntreprise();
        System.out.println("Il y a " + String.valueOf(c.getCount()) + " entreprise(s)");
    }

    public void remplirTableProfesseur() {
        bddDAO professeurBdd = new bddDAO(this);
        Professeur professeur1 = new Professeur(1,"Bourgeois","Nicolas","nbourgeois@gmail.com","0645857695");

        //on ouvre la base de données
        professeurBdd.open();
        //on insère professeur1
        professeurBdd.insererProfesseur(professeur1);

        //le curseur pour afficher le nombre d'entreprise dans la base
        Cursor c = professeurBdd.getDataProfesseur();
        System.out.println("Il y a " + String.valueOf(c.getCount()) + " professeur(s)");
    }

    public void remplirTuteur() {
        bddDAO tuteurBdd = new bddDAO(this);
        Tuteur tuteur1 = new Tuteur(1,1,"Fonteneau","Mattthieu","0645857695", "fonteneau.mattt@gmail.com");

        //on ouvre la base de données
        tuteurBdd.open();
        //on insère tuteur1
        tuteurBdd.insererTuteur(tuteur1);

        //le curseur pour afficher le nombre d'entreprise dans la base
        Cursor c = tuteurBdd.getDataTuteur();
        System.out.println("Il y a " + String.valueOf(c.getCount()) + " tuteur(s)");
    }

    public void remplirVisite() {
        bddDAO visiteBdd = new bddDAO(this);
        Visite visite1 = new Visite(1,1,1,1,"12/01/2001","Zomega","raksé","caillou", "raksé", 1, 1, "2001");

        //on ouvre la base de données
        visiteBdd.open();
        //on insère tuteur1
        visiteBdd.insererVisite(visite1);

        //le curseur pour afficher le nombre d'entreprise dans la base
        Cursor c = visiteBdd.getDataVisite();
        System.out.println("Il y a " + String.valueOf(c.getCount()) + " visite(s)");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
      // remplirTableEtudiant();
      // remplirTableEntreprise();
      // remplirTableProfesseur();
      //  remplirTuteur();
      //  remplirVisite();

        Button btnAdmin = (Button) findViewById(R.id.buttonAdmin);
        Button btnNewVisite = (Button) findViewById(R.id.buttonNvVisite);
        Button btnListeVisites = (Button) findViewById(R.id.buttonConsultVisite);


        OnClickListener ecouteur = new OnClickListener(){
            public void onClick(View v){
                switch(v.getId()) {
                    case R.id.buttonNvVisite:
                    startActivity(new Intent(MainActivity.this, NvVisiteActivity.class));
                    break;
                    case R.id.buttonAdmin:
                        startActivity(new Intent(MainActivity.this, AdminMenuActivity.class));
                        break;
                    case R.id.buttonConsultVisite:
                        startActivity(new Intent(MainActivity.this, ListeVisitesActivity.class));
                        break;
                }
            }
        };

        btnAdmin.setOnClickListener(ecouteur);
        btnNewVisite.setOnClickListener(ecouteur);
        btnListeVisites.setOnClickListener(ecouteur);

    }
}