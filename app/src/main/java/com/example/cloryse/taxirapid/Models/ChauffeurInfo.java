package com.example.cloryse.taxirapid.Models;

public class ChauffeurInfo {

    private String Last_name;
    private String First_name;
    private String Brand_Vehicle;
    private String Numberplate;

    public ChauffeurInfo(){

    }

    public ChauffeurInfo(String nom, String prenom, String plaqueImmatriculation, String marqueVoiture) {
        this.Last_name= nom;
        this.First_name= prenom;
        this.Numberplate = plaqueImmatriculation;
        this.Brand_Vehicle= marqueVoiture;
    }

    public String getNom() {
        return Last_name;
    }

    public void setNom(String nom) {
        this.Last_name = nom;
    }

    public String getPrenom() {
        return First_name;
    }

    public void setPrenom(String prenom) {
        this.First_name = prenom;
    }

    public String getPlaqueImmatriculation() {
        return Numberplate;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.Numberplate= plaqueImmatriculation;
    }

    public String getMarqueVoiture() {
        return Brand_Vehicle;
    }

    public void setMarqueVoiture(String marqueVoiture) {
        this.Brand_Vehicle = marqueVoiture;
    }
}
