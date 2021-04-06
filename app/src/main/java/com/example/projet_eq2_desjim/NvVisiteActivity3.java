package com.example.projet_eq2_desjim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NvVisiteActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nvlvisite3);

        Button btnSuivant = (Button) findViewById(R.id.button4);
        Button btnPrecedent = (Button) findViewById(R.id.button5);
        View.OnClickListener ecouteur = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()) {
                    case R.id.button4:
                        startActivity(new Intent(NvVisiteActivity3.this, NvVisiteActivity4.class));
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
