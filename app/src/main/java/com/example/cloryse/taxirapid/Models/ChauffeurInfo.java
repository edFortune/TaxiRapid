package com.example.cloryse.taxirapid.Models;

public class ChauffeurInfo {

    private String nom;
    private String prenom;
    private String plaqueImmatriculation;
    private String marqueVoiture;

    public ChauffeurInfo(){

    }

    public ChauffeurInfo(String nom, String prenom, String plaqueImmatriculation, String marqueVoiture) {
        this.nom = nom;
        this.prenom = prenom;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.marqueVoiture = marqueVoiture;
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

    public String getPlaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    public String getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(String marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }
}
