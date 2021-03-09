package Metier;

public class Visite {

    int id;
    String date;
    String conditions;
    String bilan;
    String resOutils;
    String commentaires;
    boolean participation;
    boolean opportunite;
    String session;

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

    public boolean isParticipation() {
        return participation;
    }

    public void setParticipation(boolean participation) {
        this.participation = participation;
    }

    public boolean isOpportunite() {
        return opportunite;
    }

    public void setOpportunite(boolean opportunite) {
        this.opportunite = opportunite;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
