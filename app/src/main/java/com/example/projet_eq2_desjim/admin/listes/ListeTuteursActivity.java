package com.example.projet_eq2_desjim.admin.listes;

        import android.database.Cursor;
        import android.os.Bundle;
        import android.widget.ListView;
        import android.widget.SimpleCursorAdapter;

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.projet_eq2_desjim.R;

        import bdd.bddDAO;

public class ListeTuteursActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listetuteurs);

        bddDAO DaoTuteurs = new bddDAO(this);

        ListView listViewEtudiants = findViewById(R.id.listeleves);

        DaoTuteurs.open();

        Cursor c = DaoTuteurs.getDataTuteur();

        // colonnes à afficher
        String[] columns = new String[]{bddDAO.COL_ID_TUTEUR, bddDAO.COL_NOM_TUTEUR, bddDAO.COL_PRENOM_TUTEUR, bddDAO.COL_EMAIL_TUTEUR, bddDAO.COL_NUMTEL_TUTEUR, bddDAO.COL_ID_ENTREPRISE_TUTEUR };

        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.textView2, R.id.textView6, R.id.textView7, R.id.textView8,  R.id.textView9,  R.id.textView10};

        //on choisit le type d’adapter pour notre affichage de la liste
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.layout_listetuteurs, c, columns, to, 0);

        // on assigne cet adapter à notre ListView
        listViewEtudiants.setAdapter(dataAdapter);

        //on ferme la table
        DaoTuteurs.close();
    }
}

