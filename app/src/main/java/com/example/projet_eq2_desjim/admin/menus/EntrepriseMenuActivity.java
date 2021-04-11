package com.example.projet_eq2_desjim.admin.menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.MainActivity;
import com.example.projet_eq2_desjim.R;
import com.example.projet_eq2_desjim.admin.ajouter.AjouterEntrepriseActivity;
import com.example.projet_eq2_desjim.admin.ajouter.AjouterEtudiantActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeEntreprisesActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeEtudiantsActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeProfesseursActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeTuteursActivity;

public class EntrepriseMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menuentreprise);

        Button btnListe = (Button) findViewById(R.id.button4);
        Button btnAjouter = (Button) findViewById(R.id.button5);
        Button btnRetour = (Button) findViewById(R.id.button6);


        View.OnClickListener ecouteur = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()) {
                    case R.id.button4:
                        startActivity(new Intent(EntrepriseMenuActivity.this, ListeEntreprisesActivity.class));
                        break;
                    case R.id.button5:
                        startActivity(new Intent(EntrepriseMenuActivity.this, AjouterEntrepriseActivity.class));
                        break;
                    case R.id.button6:
                        startActivity(new Intent(EntrepriseMenuActivity.this, AdminMenuActivity.class));
                        break;
                }
            }
        };

        btnListe.setOnClickListener(ecouteur);
        btnAjouter.setOnClickListener(ecouteur);
        btnRetour.setOnClickListener(ecouteur);
    }
}
