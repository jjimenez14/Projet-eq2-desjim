package com.example.projet_eq2_desjim.admin.listes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;
import com.example.projet_eq2_desjim.admin.AdminMenuActivity;
import com.example.projet_eq2_desjim.admin.ajouter.AjouterEtudiantActivity;

public class ListeEtudiantsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listeetudiants);

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