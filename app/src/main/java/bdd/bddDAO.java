package bdd;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import Metier.*;

public class bddDAO  {
    static final int VERSION_BDD =12;
    private static final String NOM_BDD = "siobdd.db";

//--------------------------------------------------------------------------------------------------

    public static final String TABLE_ENTREPRISE = "table_entreprise";

    public static final String COL_ID_ENTREPRISE = "_id";
    public static final int NUM_COL_ID_ENTREPRISE = 0;

    public static final String COL_NOM_ENTREPRISE = "NomEntreprise";
    public static final int NUM_COL_NOM_ENTREPRISE = 1;

    public static final String COL_ADRESSE_ENTREPRISE = "AdresseEntreprise";
    public static final int NUM_COL_ADRESSE_ENTREPRISE = 2;

    public static final String COL_NUMTEL_ENTREPRISE = "NumTelEntreprise";
    public static final int NUM_COL_NUMTEL_ENTREPRISE = 3;

//--------------------------------------------------------------------------------------------------

    public static final String TABLE_ETUDIANT = "table_etudiant";

    public static final String COL_ID_ETUDIANT = "_id";
    public static final int NUM_COL_ID_ETUDIANT = 0;

    public static final String COL_NOM_ETUDIANT = "NomEtudiant";
    public static final int NUM_COL_NOM_ETUDIANT = 1;

    public static final String COL_PRENOM_ETUDIANT = "PrenomEtudiant";
    public static final int NUM_COL_PRENOM_ETUDIANT = 2;

    public static final String COL_CLASSE_ETUDIANT = "Classe";
    public static final int NUM_COL_CLASSE_ETUDIANT = 3;

    public static final String COL_ANNEE_ETUDIANT = "Année";
    public static final int NUM_COL_ANNEE_ETUDIANT = 4;

//--------------------------------------------------------------------------------------------------

    public static final String TABLE_PROFESSEUR = "table_professeur";

    public static final String COL_ID_PROFESSEUR = "_id";
    public static final int NUM_COL_ID_PROFESSEUR = 0;

    public static final String COL_NOM_PROFESSEUR = "NomProfesseur";
    public static final int NUM_COL_NOM_PROFESSEUR = 1;

    public static final String COL_PRENOM_PROFESSEUR = "PrenomProfesseur";
    public static final int NUM_COL_PRENOM_PROFESSEUR = 2;

    public static final String COL_EMAIL_PROFESSEUR = "EmailProfesseur";
    public static final int NUM_COL_EMAIL_PROFESSEUR = 3;

    public static final String COL_NUMTEL_PROFESSEUR = "NumTelProfesseur";
    public static final int NUM_COL_NUMTEL_PROFESSEUR = 4;

//--------------------------------------------------------------------------------------------------

    public static final String TABLE_TUTEUR = "table_tuteur";

    public static final String COL_ID_TUTEUR = "_id";
    public static final int NUM_COL_ID_TUTEUR = 0;

    public static final String COL_ID_ENTREPRISE_TUTEUR = "IdEntrepriset";
    public static final int NUM_COL_ID_ENTREPRISE_TUTEUR = 1;

    public static final String COL_NOM_TUTEUR = "NomTuteur";
    public static final int NUM_COL_NOM_TUTEUR = 2;

    public static final String COL_PRENOM_TUTEUR = "PrenomTuteur";
    public static final int NUM_COL_PRENOM_TUTEUR = 3;

    public static final String COL_EMAIL_TUTEUR = "EmailTuteur";
    public static final int NUM_COL_EMAIL_TUTEUR = 4;

    public static final String COL_NUMTEL_TUTEUR = "NumTelTuteur";
    public static final int NUM_COL_NUMTEL_TUTEUR = 5;

//--------------------------------------------------------------------------------------------------

    public static final String TABLE_VISITE = "table_visite";

    public static final String COL_ID_VISITE = "_id";
    public static final int NUM_COL_ID_VISITE = 0;

    public static final String COL_ID_ETUDIANT_VISITE = "IdEtudiantv";
    public static final int NUM_COL_ID_ETUDIANT_VISITE = 1;

    public static final String COL_ID_TUTEUR_VISITE = "IdTuteurv";
    public static final int NUM_COL_ID_TUTEUR_VISITE = 2;

    public static final String COL_ID_PROFESSEUR_VISITE = "IdProfesseurv";
    public static final int NUM_COL_ID_PROFESSEUR_VISITE = 3;

    public static final String COL_DATE_VISITE = "DateVisite";
    public static final int NUM_COL_DATE_VISITE = 4;

    public static final String COL_CONDITIONS_VISITE = "ConditionsVisite";
    public static final int NUM_COL_CONDITIONS_VISITE = 5;

    public static final String COL_BILAN_VISITE = "BilanVisite";
    public static final int NUM_COL_BILAN_VISITE = 6;

    public static final String COL_RESOUTILS_VISITE = "ResOutilsVisite";
    public static final int NUM_COL_RESOUTILS_VISITE = 7;

    public static final String COL_COMMENTAIRES_VISITE = "CommentairesVisite";
    public static final int NUM_COL_COMMENTAIRES_VISITE = 8;

    public static final String COL_PARTICIPATION_VISITE = "ParticipationVisite";
    public static final int NUM_COL_PARTICIPATION_VISITE = 9;

    public static final String COL_OPPORTUNITE_VISITE = "OpportunitéVisite";
    public static final int NUM_COL_OPPORTUNITE_VISITE = 10;

    public static final String COL_SESSION_VISITE = "SessionVisite";
    public static final int NUM_COL_SESSION_VISITE = 11;

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

    public Cursor getDataEtudiantById(int idetudiant){ return db.rawQuery("SELECT * FROM table_etudiant WHERE _id = " + "\"" + idetudiant + "\"",null);}

    public Cursor getDataEntrepriseById(int identreprise){ return db.rawQuery("SELECT * FROM table_entreprise WHERE _id = " + "\"" + identreprise + "\"",null);}

    public Cursor getDataProfesseurById(int idprofesseur){ return db.rawQuery("SELECT * FROM table_professeur WHERE _id = " + "\"" + idprofesseur + "\"",null);}

    public Cursor getDataTuteurById(int idtuteur){ return db.rawQuery("SELECT * FROM table_tuteur WHERE _id = " + "\"" + idtuteur + "\"",null);}

    public Cursor getDataVisiteById(int idvisite){ return db.rawQuery("SELECT * FROM table_visite WHERE _id = " + "\"" + idvisite + "\"",null);}

    public Cursor getInfoForTab(){ return db.rawQuery("SELECT v._id, e.NomEtudiant, t.NomTuteur, p.NomProfesseur, DateVisite FROM table_visite v" +
            " INNER JOIN table_etudiant e ON v.IdEtudiantv = e._id" +
            " INNER JOIN table_tuteur t  ON v.IdTuteurv = t._id" +
            " INNER JOIN table_professeur p ON v.IdProfesseurv = p._id"
            ,null);}

//--------------------------------------------------------------------------------------------------

    private Etudiant cursorToEtudiant(Cursor c){

        if (c.getCount() == 0)
            return null;
        c.moveToFirst(); //on se place sur le premier élément
        Etudiant unEtudiant = new Etudiant(null,null,null, 0); //On créé un étudiant
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unEtudiant.setNom(c.getString(NUM_COL_NOM_ETUDIANT));
        unEtudiant.setPrenom(c.getString(NUM_COL_PRENOM_ETUDIANT));
        unEtudiant.setClasse(c.getString(NUM_COL_CLASSE_ETUDIANT));
        unEtudiant.setAnnee(c.getInt(NUM_COL_ANNEE_ETUDIANT));
        c.close(); //On ferme le cursor
        return unEtudiant; //On retourne l'étudiant
    }



    public static String[] cursorToEtudiant2(Cursor c){
        ArrayList<String> desEtudiants = new ArrayList<String>();
        if (c.getCount() != 0) {
            c.moveToFirst(); //on se place sur le premier élément
            while (!c.isAfterLast()) {
                String unEtudiant;
                unEtudiant = c.getString(NUM_COL_NOM_ETUDIANT) + " " + c.getString(NUM_COL_PRENOM_ETUDIANT) + " " + c.getString(NUM_COL_CLASSE_ETUDIANT);
                desEtudiants.add(unEtudiant);
                c.moveToNext();
            }
            c.close(); //On ferme le cursor
        }
        return desEtudiants.toArray(new String[desEtudiants.size()]); //On retourne une collection d'étudiants en format String
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

    public static String[] cursorToEntreprise2(Cursor c){
        ArrayList<String> desEntreprises = new ArrayList<String>();
        if (c.getCount() != 0) {
            c.moveToFirst(); //on se place sur le premier élément
            while (!c.isAfterLast()) {
                String uneEntreprise;
                uneEntreprise = c.getString(NUM_COL_NOM_ENTREPRISE) + " " + c.getString(NUM_COL_ADRESSE_ENTREPRISE);
                desEntreprises.add(uneEntreprise);
                c.moveToNext();
            }
            c.close(); //On ferme le cursor
        }
        return desEntreprises.toArray(new String[desEntreprises.size()]); //On retourne une collection d'étudiants en format String
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

    public static String[] cursorToProfesseur2(Cursor c){
        ArrayList<String> desProfesseurs = new ArrayList<String>();
        if (c.getCount() != 0) {
            c.moveToFirst(); //on se place sur le premier élément
            while (!c.isAfterLast()) {
                String unProfesseur;
                unProfesseur = c.getString(NUM_COL_NOM_PROFESSEUR) + " " + c.getString(NUM_COL_PRENOM_PROFESSEUR);
                desProfesseurs.add(unProfesseur);
                c.moveToNext();
            }
            c.close(); //On ferme le cursor
        }
        return desProfesseurs.toArray(new String[desProfesseurs.size()]); //On retourne une collection d'étudiants en format String
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

    public static String[] cursorToTuteur2(Cursor c){
        ArrayList<String> desTuteurs = new ArrayList<String>();
        if (c.getCount() != 0) {
            c.moveToFirst(); //on se place sur le premier élément
            while (!c.isAfterLast()) {
                String unTuteur;
                unTuteur = c.getString(NUM_COL_NOM_TUTEUR) + " " + c.getString(NUM_COL_PRENOM_TUTEUR);
                desTuteurs.add(unTuteur);
                c.moveToNext();
            }
            c.close(); //On ferme le cursor
        }
        return desTuteurs.toArray(new String[desTuteurs.size()]); //On retourne une collection d'étudiants en format String
    }

}
