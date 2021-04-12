package com.example.projet_eq2_desjim.NvVisite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.MainActivity;
import com.example.projet_eq2_desjim.R;

import Metier.Visite;
import bdd.bddDAO;

public class NvVisiteActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nvlvisite4);

        Intent intent = getIntent();


            int etudiant = intent.getIntExtra("etudiant",0);
        int prof = intent.getIntExtra("prof",0);
        int tuteur = intent.getIntExtra("tuteur",0);

            String date = intent.getStringExtra("date");
            String conditions = intent.getStringExtra("conditions");
            String bilan = intent.getStringExtra("bilan");
            String ressources = intent.getStringExtra("ressources");
            String commentaires = intent.getStringExtra("commentaires");

        Button btnSuivant = (Button) findViewById(R.id.button4);
        Button btnPrecedent = (Button) findViewById(R.id.button5);

        RadioButton radioButton3 = (RadioButton)  findViewById(R.id.radioButton3);
        RadioButton radioButton4 = (RadioButton)  findViewById(R.id.radioButton4);
        RadioButton radioButton5 = (RadioButton)  findViewById(R.id.radioButton5);
        RadioButton radioButton6 = (RadioButton)  findViewById(R.id.radioButton6);
        RadioButton radioButton7 = (RadioButton)  findViewById(R.id.radioButton7);
        RadioButton radioButton8 = (RadioButton)  findViewById(R.id.radioButton8);

        bddDAO NvBdd = new bddDAO(this);
        NvBdd.open();

        View.OnClickListener ecouteur = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()) {
                    case R.id.button4:

                        int participation=0;
                        int opportunite=0;
                        String session=null;


                        if(radioButton3.isChecked()){
                            participation = 1;
                        } else if (radioButton4.isChecked()){
                            participation = 0;
                        }

                        if(radioButton5.isChecked()){
                            opportunite = 1;
                        } else if (radioButton6.isChecked()){
                            opportunite = 0;
                        }
                        if(radioButton7.isChecked()){
                            session = "Mai-Juin";
                        } else if (radioButton8.isChecked()){
                            session = "Janvier-Fevrier";
                        } else {
                            session = null;
                        }

                        Visite laVisite = new Visite(etudiant,tuteur,prof,date,conditions,bilan,ressources,commentaires,participation,opportunite,session);
                        NvBdd.insererVisite(laVisite);


                        startActivity(new Intent(NvVisiteActivity4.this, MainActivity.class));
                        Toast.makeText(getApplicationContext(), "La visite a bien été ajoutée.", Toast.LENGTH_LONG).show();

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
