package com.example.projet_eq2_desjim.admin.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.MainActivity;
import com.example.projet_eq2_desjim.R;
import com.example.projet_eq2_desjim.admin.listes.ListeEntreprisesActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeEtudiantsActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeProfesseursActivity;
import com.example.projet_eq2_desjim.admin.listes.ListeTuteursActivity;

public class AdminMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_admin);

        Button btnEtudiants = (Button) findViewById(R.id.buttonElv);
        Button btnEntreprises = (Button) findViewById(R.id.buttonEntrpr);
        Button btnProfesseurs = (Button) findViewById(R.id.buttonProf);
        Button btnTuteurs = (Button) findViewById(R.id.buttonTuteur);
        Button btnRetour = (Button) findViewById(R.id.button2);


        View.OnClickListener ecouteur = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()) {
                    case R.id.buttonElv:
                        startActivity(new Intent(AdminMenuActivity.this, ListeEtudiantsActivity.class));
                        break;
                    case R.id.buttonEntrpr:
                        startActivity(new Intent(AdminMenuActivity.this, ListeEntreprisesActivity.class));
                        break;
                    case R.id.buttonProf:
                        startActivity(new Intent(AdminMenuActivity.this, ListeProfesseursActivity.class));
                        break;
                    case R.id.buttonTuteur:
                        startActivity(new Intent(AdminMenuActivity.this, ListeTuteursActivity.class));
                        break;
                    case R.id.button2:
                        startActivity(new Intent(AdminMenuActivity.this, MainActivity.class));
                        break;
                }
            }
        };

        btnEtudiants.setOnClickListener(ecouteur);
        btnEntreprises.setOnClickListener(ecouteur);
        btnProfesseurs.setOnClickListener(ecouteur);
        btnTuteurs.setOnClickListener(ecouteur);
        btnRetour.setOnClickListener(ecouteur);

    }

}
