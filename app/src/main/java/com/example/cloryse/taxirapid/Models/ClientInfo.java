package com.example.cloryse.taxirapid.Models;

public class ClientInfo extends ClientId {

    private String Last_name;
    private String First_name;

    public ClientInfo(){

    }

    public ClientInfo(String nom, String prenom) {
        this.Last_name = nom;
        this.First_name = prenom;
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
        this.First_name= prenom;
    }
}
