package bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBDD extends SQLiteOpenHelper {

    private static final String TABLE_ETUDIANT = "table_etudiant";
    static final String COL_ID_ETUDIANT = "_idetudiant";
    private static final String COL_NOM_ETUDIANT = "NomEtudiant";
    private static final String COL_PRENOM_ETUDIANT = "PrenomEtudiant";
    private static final String COL_CLASSE_ETUDIANT = "Classe";
    private static final String COL_ANNEE_ETUDIANT = "Année";

    private static final String CREATE_TABLE_ETUDIANT = "CREATE TABLE " + TABLE_ETUDIANT +  " (" +COL_ID_ETUDIANT
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM_ETUDIANT
            + " TEXT NOT NULL, "
            + COL_PRENOM_ETUDIANT
            + " TEXT NOT NULL, "
            + COL_CLASSE_ETUDIANT
            + " TEXT NOT NULL, "
            + COL_ANNEE_ETUDIANT
            + " INTEGER NOT NULL);";


    private static final String TABLE_ENTREPRISE = "table_entreprise";
    static final String COL_ID_ENTREPRISE = "_identreprise";
    private static final String COL_NOM_ENTREPRISE = "NomEntreprise";
    private static final String COL_ADRESSE_ENTREPRISE = "AdresseEntreprise";
    private static final String COL_NUMTEL_ENTREPRISE = "NumTelEntreprise";

    private static final String CREATE_TABLE_ENTREPRISE = "CREATE TABLE " + TABLE_ENTREPRISE +  " (" +COL_ID_ENTREPRISE
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM_ENTREPRISE
            + " TEXT NOT NULL, "
            + COL_ADRESSE_ENTREPRISE
            + " TEXT NOT NULL, "
            + COL_NUMTEL_ENTREPRISE
            + " TEXT NOT NULL);";


    private static final String TABLE_PROFESSEUR = "table_professeur";
    static final String COL_ID_PROFESSEUR = "_idprofesseur";
    private static final String COL_NOM_PROFESSEUR = "NomProfesseur";
    private static final String COL_PRENOM_PROFESSEUR = "PrenomProfesseur";
    private static final String COL_EMAIL_PROFESSEUR = "EmailEntreprise";
    private static final String COL_NUMTEL_PROFESSEUR = "NumTelProfesseur";

    private static final String CREATE_TABLE_PROFESSEUR = "CREATE TABLE " + TABLE_PROFESSEUR +  " (" +COL_ID_PROFESSEUR
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM_PROFESSEUR
            + " TEXT NOT NULL, "
            + COL_PRENOM_PROFESSEUR
            + " TEXT NOT NULL, "
            + COL_EMAIL_PROFESSEUR
            + " TEXT NOT NULL, "
            + COL_NUMTEL_PROFESSEUR
            + " TEXT NOT NULL);";


    private static final String TABLE_TUTEUR = "table_tuteur";
    static final String COL_ID_TUTEUR = "_idtuteur";
    private static final String COL_ID_ENTREPRISE_TUTEUR = "IdEntrepriset";
    private static final String COL_NOM_TUTEUR = "NomTuteur";
    private static final String COL_PRENOM_TUTEUR = "PrenomTuteur";
    private static final String COL_EMAIL_TUTEUR = "EmailTuteur";
    private static final String COL_NUMTEL_TUTEUR = "NumTelTuteur";

    private static final String CREATE_TABLE_TUTEUR = "CREATE TABLE " + TABLE_TUTEUR +  " (" +COL_ID_TUTEUR
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_ENTREPRISE_TUTEUR
            + " INTEGER NOT NULL, "
            + COL_NOM_TUTEUR
            + " TEXT NOT NULL, "
            + COL_PRENOM_TUTEUR
            + " TEXT NOT NULL, "
            + COL_EMAIL_TUTEUR
            + " TEXT NOT NULL, "
            + COL_NUMTEL_TUTEUR
            + " TEXT NOT NULL);";



    private static final String TABLE_VISITE = "table_visite";
    static final String COL_ID_VISITE = "_idvisite";
    private static final String COL_ID_ETUDIANT_VISITE = "IdEtudiantv";
    private static final String COL_ID_TUTEUR_VISITE = "IdTuteurv";
    private static final String COL_ID_PROFESSEUR_VISITE = "IdProfesseurv";
    private static final String COL_DATE_VISITE = "DateVisite";
    private static final String COL_CONDITIONS_VISITE = "ConditionsVisite";
    private static final String COL_BILAN_VISITE = "BilanVisite";
    private static final String COL_RESOUTILS_VISITE = "ResOutilsVisite";
    private static final String COL_COMMENTAIRES_VISITE = "CommentairesVisite";
    private static final String COL_PARTICIPATION_VISITE = "ParticipationVisite";
    private static final String COL_OPPORTUNITE_VISITE = "OpportunitéVisite";
    private static final String COL_SESSION_VISITE = "SessionVisite";

    private static final String CREATE_TABLE_VISITE = "CREATE TABLE " + TABLE_VISITE +  " (" +COL_ID_VISITE
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_ETUDIANT_VISITE
            + " INTEGER NOT NULL, "
            + COL_ID_TUTEUR_VISITE
            + " INTEGER NOT NULL, "
            + COL_ID_PROFESSEUR_VISITE
            + " INTEGER NOT NULL, "
            + COL_DATE_VISITE
            + " TEXT NOT NULL, "
            + COL_CONDITIONS_VISITE
            + " TEXT NOT NULL, "
            + COL_BILAN_VISITE
            + " TEXT NOT NULL, "
            + COL_RESOUTILS_VISITE
            + " TEXT NOT NULL, "
            + COL_COMMENTAIRES_VISITE
            + " TEXT NOT NULL, "
            + COL_PARTICIPATION_VISITE
            + " INTEGER NOT NULL, "
            + COL_OPPORTUNITE_VISITE
            + " INTEGER NOT NULL, "
            + COL_SESSION_VISITE
            + " TEXT NOT NULL);";


    //constructeur paramétré
    public CreateBDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //méthodes d'instance permettant la gestion de l'objet
    @Override
    public void onCreate(SQLiteDatabase db) {
        //appelée lorsqu’aucune base n’existe et que la classe utilitaire doit encréer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLE_ETUDIANT);
        db.execSQL(CREATE_TABLE_ENTREPRISE);
        db.execSQL(CREATE_TABLE_PROFESSEUR);
        db.execSQL(CREATE_TABLE_TUTEUR);
        db.execSQL(CREATE_TABLE_VISITE);
    }
    // appelée si la version de la base a changé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut supprimer la table et de la recréer
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENTREPRISE + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFESSEUR + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TUTEUR + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITE + " ;");
        onCreate(db);
    }
}