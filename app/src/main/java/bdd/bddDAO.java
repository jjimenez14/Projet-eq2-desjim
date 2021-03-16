package bdd;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

public class bddDAO {
    static final int VERSION_BDD =1;
    private static final String NOM_BDD = "siobdd.db";


/*
    static final String TABLE_LAC = "table_lac";
    static final String COL_ID_LAC = "_idlac";
    static final int NUM_COL_ID_LAC = 0;
    static final String COL_NOM_LACL = "NomLacL";
    static final int NUM_COL_NOM_LACL = 1;
    static final String COL_COORDONNEES = "Coordonnees";
    static final int NUM_COL_COORDONNEES = 2;
*/


    private bddDAO tableCourante;
    private Context context;
    private SQLiteDatabase db;

    public bddDAO (Context context){
        this.context = context;
        tableCourante = new bddDAO(context);
    }

    public bddDAO open(){
        db = tableCourante.getWritableDataBase();
        return this;
    }

    public bddDAO close (){
        db.close();
        return null;
    }






    public long insererLac (Lac unLac){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM_LACL, unLac.getNomLacL());
        values.put(COL_COORDONNEES, unLac.getCoordonnees());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_LAC, null, values);
    }
}
