package Metier;

public class Tuteur {


    int id;
    int idEntrepriset;
    String nom;
    String prenom;
    String email;
    String numTel;

    public Tuteur(int id, int idEntrepriset, String nom, String prenom, String email, String numTel) {
        this.id = id;
        this.idEntrepriset = idEntrepriset;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numTel = numTel;
    }

    public int getIdEntrepriset() {
        return idEntrepriset;
    }

    public void setIdEntrepriset(int idEntrepriset) {
        this.idEntrepriset = idEntrepriset;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}

