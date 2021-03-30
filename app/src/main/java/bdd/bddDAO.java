package bdd;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import Metier.*;

public class bddDAO  {
    static final int VERSION_BDD =4;
    private static final String NOM_BDD = "siobdd.db";

//--------------------------------------------------------------------------------------------------

    static final String TABLE_ENTREPRISE = "table_entreprise";

    static final String COL_ID_ENTREPRISE = "_identreprise";
    static final int NUM_COL_ID_ENTREPRISE = 0;

    static final String COL_NOM_ENTREPRISE = "NomEntreprise";
    static final int NUM_COL_NOM_ENTREPRISE = 1;

    static final String COL_ADRESSE_ENTREPRISE = "AdresseEntreprise";
    static final int NUM_COL_ADRESSE_ENTREPRISE = 2;

    static final String COL_NUMTEL_ENTREPRISE = "NumTelEntreprise";
    static final int NUM_COL_NUMTEL_ENTREPRISE = 3;

//--------------------------------------------------------------------------------------------------

    static final String TABLE_ETUDIANT = "table_etudiant";

    static final String COL_ID_ETUDIANT = "_idetudiant";
    static final int NUM_COL_ID_ETUDIANT = 0;

    static final String COL_NOM_ETUDIANT = "NomEtudiant";
    static final int NUM_COL_NOM_ETUDIANT = 1;

    static final String COL_PRENOM_ETUDIANT = "PrenomEtudiant";
    static final int NUM_COL_PRENOM_ETUDIANT = 2;

    static final String COL_CLASSE_ETUDIANT = "Classe";
    static final int NUM_COL_CLASSE_ETUDIANT = 3;

    static final String COL_ANNEE_ETUDIANT = "Année";
    static final int NUM_COL_ANNEE_ETUDIANT = 4;

//--------------------------------------------------------------------------------------------------

    static final String TABLE_PROFESSEUR = "table_professeur";

    static final String COL_ID_PROFESSEUR = "_idprofesseur";
    static final int NUM_COL_ID_PROFESSEUR = 0;

    static final String COL_NOM_PROFESSEUR = "NomProfesseur";
    static final int NUM_COL_NOM_PROFESSEUR = 1;

    static final String COL_PRENOM_PROFESSEUR = "PrenomProfesseur";
    static final int NUM_COL_PRENOM_PROFESSEUR = 2;

    static final String COL_EMAIL_PROFESSEUR = "EmailProfesseur";
    static final int NUM_COL_EMAIL_PROFESSEUR = 3;

    static final String COL_NUMTEL_PROFESSEUR = "NumTelProfesseur";
    static final int NUM_COL_NUMTEL_PROFESSEUR = 4;

//--------------------------------------------------------------------------------------------------

    static final String TABLE_TUTEUR = "table_tuteur";

    static final String COL_ID_TUTEUR = "_idtuteur";
    static final int NUM_COL_ID_TUTEUR = 0;

    static final String COL_ID_ENTREPRISE_TUTEUR = "IdEntrepriset";
    static final int NUM_COL_ID_ENTREPRISE_TUTEUR = 1;

    static final String COL_NOM_TUTEUR = "NomTuteur";
    static final int NUM_COL_NOM_TUTEUR = 2;

    static final String COL_PRENOM_TUTEUR = "PrenomTuteur";
    static final int NUM_COL_PRENOM_TUTEUR = 3;

    static final String COL_EMAIL_TUTEUR = "EmailTuteur";
    static final int NUM_COL_EMAIL_TUTEUR = 4;

    static final String COL_NUMTEL_TUTEUR = "NumTelTuteur";
    static final int NUM_COL_NUMTEL_TUTEUR = 5;

//--------------------------------------------------------------------------------------------------

    static final String TABLE_VISITE = "table_visite";

    static final String COL_ID_VISITE = "_idvisite";
    static final int NUM_COL_ID_VISITE = 0;

    static final String COL_ID_ETUDIANT_VISITE = "IdEtudiantv";
    static final int NUM_COL_ID_ETUDIANT_VISITE = 1;

    static final String COL_ID_TUTEUR_VISITE = "IdTuteurv";
    static final int NUM_COL_ID_TUTEUR_VISITE = 2;

    static final String COL_ID_PROFESSEUR_VISITE = "IdProfesseurv";
    static final int NUM_COL_ID_PROFESSEUR_VISITE = 3;

    static final String COL_DATE_VISITE = "DateVisite";
    static final int NUM_COL_DATE_VISITE = 4;

    static final String COL_CONDITIONS_VISITE = "ConditionsVisite";
    static final int NUM_COL_CONDITIONS_VISITE = 5;

    static final String COL_BILAN_VISITE = "BilanVisite";
    static final int NUM_COL_BILAN_VISITE = 6;

    static final String COL_RESOUTILS_VISITE = "ResOutilsVisite";
    static final int NUM_COL_RESOUTILS_VISITE = 7;

    static final String COL_COMMENTAIRES_VISITE = "CommentairesVisite";
    static final int NUM_COL_COMMENTAIRES_VISITE = 8;

    static final String COL_PARTICIPATION_VISITE = "ParticipationVisite";
    static final int NUM_COL_PARTICIPATION_VISITE = 9;

    static final String COL_OPPORTUNITE_VISITE = "OpportunitéVisite";
    static final int NUM_COL_OPPORTUNITE_VISITE = 10;

    static final String COL_SESSION_VISITE = "SessionVisite";
    static final int NUM_COL_SESSION_VISITE = 11;

//--------------------------------------------------------------------------------------------------
    private CreateBDD tableCourante;
    private Context context;
    private SQLiteDatabase db;

    public bddDAO (Context context){
        this.context = context;
        tableCourante = new CreateBDD(context, NOM_BDD, null, VERSION_BDD);
    }

    public bddDAO open(){
        db = tableCourante.getWritableDatabase();
        return this;
    }

    public bddDAO close (){
        db.close();
        return null;
    }

//--------------------------------------------------------------------------------------------------

    public long insererEntreprise (Entreprise uneEntreprise){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM_ENTREPRISE, uneEntreprise.getNom());
        values.put(COL_ADRESSE_ENTREPRISE, uneEntreprise.getAdresse());
        values.put(COL_NUMTEL_ENTREPRISE, uneEntreprise.getNumTel());

        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_ENTREPRISE, null, values);
    }

//--------------------------------------------------------------------------------------------------

    public long insererEtudiant (Etudiant unEtudiant){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM_ETUDIANT, unEtudiant.getNom());
        values.put(COL_PRENOM_ETUDIANT, unEtudiant.getPrenom());
        values.put(COL_CLASSE_ETUDIANT, unEtudiant.getClasse());
        values.put(COL_ANNEE_ETUDIANT, unEtudiant.getAnnee());

        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_ETUDIANT, null, values);
    }

//--------------------------------------------------------------------------------------------------

    public long insererProfesseur (Professeur unProfesseur){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM_PROFESSEUR, unProfesseur.getNom());
        values.put(COL_PRENOM_PROFESSEUR, unProfesseur.getPrenom());
        values.put(COL_EMAIL_PROFESSEUR, unProfesseur.getEmail());
        values.put(COL_NUMTEL_PROFESSEUR, unProfesseur.getNumTel());


        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_PROFESSEUR, null, values);
    }

//--------------------------------------------------------------------------------------------------

    public long insererTuteur (Tuteur unTuteur){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_ID_ENTREPRISE_TUTEUR, unTuteur.getIdEntrepriset());
        values.put(COL_NOM_TUTEUR, unTuteur.getNom());
        values.put(COL_PRENOM_TUTEUR, unTuteur.getPrenom());
        values.put(COL_EMAIL_TUTEUR, unTuteur.getEmail());
        values.put(COL_NUMTEL_TUTEUR, unTuteur.getNumTel());


        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_TUTEUR, null, values);
    }

//--------------------------------------------------------------------------------------------------

    public long insererVisite (Visite uneVisite){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_ID_ETUDIANT_VISITE, uneVisite.getIdEtudiant());
        values.put(COL_ID_TUTEUR_VISITE, uneVisite.getIdTuteur());
        values.put(COL_ID_PROFESSEUR_VISITE, uneVisite.getIdProfesseur());
        values.put(COL_DATE_VISITE, uneVisite.getDate());
        values.put(COL_CONDITIONS_VISITE, uneVisite.getConditions());
        values.put(COL_BILAN_VISITE, uneVisite.getBilan());
        values.put(COL_RESOUTILS_VISITE, uneVisite.getResOutils());
        values.put(COL_COMMENTAIRES_VISITE, uneVisite.getCommentaires());
        values.put(COL_PARTICIPATION_VISITE, uneVisite.getParticipation());
        values.put(COL_OPPORTUNITE_VISITE, uneVisite.getOpportunite());
        values.put(COL_SESSION_VISITE, uneVisite.getSession());

        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_VISITE, null, values);
    }

//--------------------------------------------------------------------------------------------------

    public Cursor getDataEtudiant(){
        return db.rawQuery("SELECT * FROM table_etudiant",null);
    }

    public Cursor getDataEntreprise(){
        return db.rawQuery("SELECT * FROM table_entreprise",null);
    }

    public Cursor getDataProfesseur(){
        return db.rawQuery("SELECT * FROM table_professeur",null);
    }

    public Cursor getDataTuteur(){
        return db.rawQuery("SELECT * FROM table_tuteur",null);
    }

    public Cursor getDataVisite(){
        return db.rawQuery("SELECT * FROM table_visite",null);
    }

    public Cursor getDataEtudiantById(int idetudiant){ return db.rawQuery("SELECT * FROM table_etudiant WHERE _idetudiant = " + "\"" + idetudiant + "\"",null);}

    public Cursor getDataEntrepriseById(int identreprise){ return db.rawQuery("SELECT * FROM table_entreprise WHERE _identreprise = " + "\"" + identreprise + "\"",null);}

    public Cursor getDataProfesseurById(int idprofesseur){ return db.rawQuery("SELECT * FROM table_professeur WHERE _idprofesseur = " + "\"" + idprofesseur + "\"",null);}

    public Cursor getDataTuteurById(int idtuteur){ return db.rawQuery("SELECT * FROM table_tuteur WHERE _idtuteur = " + "\"" + idtuteur + "\"",null);}

    public Cursor getDataVisiteById(int idvisite){ return db.rawQuery("SELECT * FROM table_visite WHERE _idvisite = " + "\"" + idvisite + "\"",null);}


//--------------------------------------------------------------------------------------------------

    private Etudiant cursorToEtudiant(Cursor c){

        if (c.getCount() == 0)
            return null;
        c.moveToFirst(); //on se place sur le premier élément
        Etudiant unEtudiant = new Etudiant(0,null,null,null, 0); //On créé un étudiant
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unEtudiant.setNom(c.getString(NUM_COL_NOM_ETUDIANT));
        unEtudiant.setPrenom(c.getString(NUM_COL_PRENOM_ETUDIANT));
        unEtudiant.setClasse(c.getString(NUM_COL_CLASSE_ETUDIANT));
        unEtudiant.setAnnee(c.getInt(NUM_COL_ANNEE_ETUDIANT));

        c.close(); //On ferme le cursor
        return unEtudiant; //On retourne l'étudiant
    }

//--------------------------------------------------------------------------------------------------

    private Entreprise cursorToEntreprise(Cursor c){

        if (c.getCount() == 0)
            return null;
        c.moveToFirst(); //on se place sur le premier élément
        Entreprise uneEntreprise = new Entreprise(0,null,null,null); //On créé un étudiant
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        uneEntreprise.setNom(c.getString(NUM_COL_NOM_ENTREPRISE));
        uneEntreprise.setAdresse(c.getString(NUM_COL_ADRESSE_ENTREPRISE));
        uneEntreprise.setNumTel(c.getString(NUM_COL_NUMTEL_ENTREPRISE));

        c.close(); //On ferme le cursor
        return uneEntreprise; //On retourne l'entreprise
    }

//--------------------------------------------------------------------------------------------------

    private Professeur cursorToProfesseur(Cursor c){

        if (c.getCount() == 0)
            return null;
        c.moveToFirst(); //on se place sur le premier élément
        Professeur unProfesseur = new Professeur(0,null,null,null, null); //On créé un étudiant
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unProfesseur.setNom(c.getString(NUM_COL_NOM_PROFESSEUR));
        unProfesseur.setPrenom(c.getString(NUM_COL_PRENOM_PROFESSEUR));
        unProfesseur.setEmail(c.getString(NUM_COL_EMAIL_PROFESSEUR));
        unProfesseur.setNumTel(c.getString(NUM_COL_NUMTEL_PROFESSEUR));

        c.close(); //On ferme le cursor
        return unProfesseur; //On retourne le professeur
    }

//--------------------------------------------------------------------------------------------------

    private Visite cursorToVisite(Cursor c){

        if (c.getCount() == 0)
            return null;
        c.moveToFirst(); //on se place sur le premier élément
        Visite uneVisite = new Visite(0,0,0,0, null, null, null, null, null , 0, 0, null); //On créé un étudiant
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        uneVisite.setIdEtudiant(c.getInt(NUM_COL_ID_ETUDIANT_VISITE));
        uneVisite.setIdTuteur(c.getInt(NUM_COL_ID_TUTEUR_VISITE));
        uneVisite.setIdProfesseur(c.getInt(NUM_COL_ID_PROFESSEUR_VISITE));
        uneVisite.setDate(c.getString(NUM_COL_DATE_VISITE));
        uneVisite.setConditions(c.getString(NUM_COL_CONDITIONS_VISITE));
        uneVisite.setBilan(c.getString(NUM_COL_BILAN_VISITE));
        uneVisite.setResOutils(c.getString(NUM_COL_RESOUTILS_VISITE));
        uneVisite.setCommentaires(c.getString(NUM_COL_COMMENTAIRES_VISITE));
        uneVisite.setParticipation(c.getInt(NUM_COL_PARTICIPATION_VISITE));
        uneVisite.setOpportunite(c.getInt(NUM_COL_OPPORTUNITE_VISITE));
        uneVisite.setSession(c.getString(NUM_COL_SESSION_VISITE));

        c.close(); //On ferme le cursor
        return uneVisite; //On retourne la visite
    }

//--------------------------------------------------------------------------------------------------

    private Tuteur cursorToTuteur(Cursor c){

        if (c.getCount() == 0)
            return null;
        c.moveToFirst(); //on se place sur le premier élément
        Tuteur unTuteur = new Tuteur(0,0,null,null, null, null); //On créé un étudiant
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unTuteur.setIdEntrepriset(c.getInt(NUM_COL_ID_ENTREPRISE_TUTEUR));
        unTuteur.setNom(c.getString(NUM_COL_NOM_TUTEUR));
        unTuteur.setPrenom(c.getString(NUM_COL_PRENOM_TUTEUR));
        unTuteur.setEmail(c.getString(NUM_COL_EMAIL_TUTEUR));
        unTuteur.setNumTel(c.getString(NUM_COL_NUMTEL_TUTEUR));

        c.close(); //On ferme le cursor
        return unTuteur; //On retourne le tuteur
    }

}
