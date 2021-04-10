package com.example.projet_eq2_desjim.ListeVisites;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet_eq2_desjim.R;

public class InfosVisiteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_infosvisite);

        Button btnRetour = (Button) findViewById(R.id.button5);


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