package com.example.projet_eq2_desjim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NvVisiteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nvlvisite);

        Button btnSuivant = (Button) findViewById(R.id.button4);
        View.OnClickListener ecouteur = new View.OnClickListener(){
            public void onClick(View v){
                switch(v.getId()) {
                    case R.id.button4:
                        startActivity(new Intent(NvVisiteActivity.this, NvVisiteActivity2.class));
                        break;
                }
            }
        };

        btnSuivant.setOnClickListener(ecouteur);


    }


}
