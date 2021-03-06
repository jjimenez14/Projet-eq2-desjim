package com.example.projet_eq2_desjim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.projet_eq2_desjim.ListeVisites.ListeVisitesActivity;
import com.example.projet_eq2_desjim.NvVisite.NvVisiteActivity;
import com.example.projet_eq2_desjim.admin.menus.AdminMenuActivity;

import bdd.*;
import Metier.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

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