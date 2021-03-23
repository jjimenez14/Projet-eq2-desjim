package Metier;

public class Visite {

    int id;
    int idEtudiant;
    int idTuteur;
    int idProfesseur;
    String date;
    String conditions;
    String bilan;
    String resOutils;
    String commentaires;
    int participation;
    int opportunite;
    String session;

    public Visite(int id, int idEtudiant, int idTuteur, int idProfesseur, String date, String conditions, String bilan, String resOutils, String commentaires, int participation, int opportunite, String session) {
        this.id = id;
        this.idEtudiant = idEtudiant;
        this.idTuteur = idTuteur;
        this.idProfesseur = idProfesseur;
        this.date = date;
        this.conditions = conditions;
        this.bilan = bilan;
        this.resOutils = resOutils;
        this.commentaires = commentaires;
        this.participation = participation;
        this.opportunite = opportunite;
        this.session = session;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public int getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }

    public int getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(int idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public String getResOutils() {
        return resOutils;
    }

    public void setResOutils(String resOutils) {
        this.resOutils = resOutils;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }

    public int getOpportunite() {
        return opportunite;
    }

    public void setOpportunite(int opportunite) {
        this.opportunite = opportunite;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
