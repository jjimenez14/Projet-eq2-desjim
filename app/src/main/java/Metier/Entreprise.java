package Metier;

public class Entreprise {

    int id;
    String nom;
    String adresse;
    String numTel;

    public Entreprise(String nom, String adresse, String numTel) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numTel = numTel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}
