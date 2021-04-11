package com.example.projet_eq2_desjim.ListeVisites;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.Date;

import Metier.Visite;
import bdd.bddDAO;

public class InfosVisiteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_infosvisite);

        Intent intent = getIntent();

        int IdVisite = 0;

        if (intent != null) {

            IdVisite = intent.getIntExtra("IdVisite",0);

        }

        bddDAO ListeVisiteBdd = new bddDAO(this);

        ListeVisiteBdd.open();

        Cursor c = ListeVisiteBdd.getDataVisiteById(IdVisite+1);
        Visite visite = ListeVisiteBdd.cursorToVisite(c);



        Button btnRetour = (Button) findViewById(R.id.button5);
        EditText editTextDate = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText editTextConditions = (EditText) findViewById(R.id.editTextTextMultiLine);
        EditText editTextBilan = (EditText) findViewById(R.id.editTextTextMultiLine2);
        EditText editTextResOutils = (EditText) findViewById(R.id.editTextTextMultiLine3);
        EditText editTextCommentaires = (EditText) findViewById(R.id.editTextTextMultiLine4);
        RadioButton radioButton3 = (RadioButton)  findViewById(R.id.radioButton3);
        RadioButton radioButton4 = (RadioButton)  findViewById(R.id.radioButton4);
        RadioButton radioButton5 = (RadioButton)  findViewById(R.id.radioButton5);
        RadioButton radioButton6 = (RadioButton)  findViewById(R.id.radioButton6);
        //EditText editTextSession = (EditText) findViewById(R.id.**);


        editTextDate.setText(visite.getDate());
        editTextConditions.setText(visite.getConditions());
        editTextBilan.setText(visite.getBilan());
        editTextResOutils.setText(visite.getResOutils());
        editTextCommentaires.setText(visite.getCommentaires());
        //editTextSession.setText(visite.getSession());


        if(visite.getParticipation() == 1) {
            radioButton3.setChecked(true);
        } else {
            radioButton4.setChecked(true);
        }

        if(visite.getOpportunite() == 1) {
            radioButton5.setChecked(true);
        } else {
            radioButton6.setChecked(true);
        }





        View.OnClickListener ecouteur = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button5:
                        finish();
                        break;
                }
            }
        };

        btnRetour.setOnClickListener(ecouteur);

    }
}