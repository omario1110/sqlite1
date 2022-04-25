package com.example.sqlite;

import java.io.Serializable;

public class produit implements Serializable {
    private int id;

    public produit() {
    }

    private String libelle ;
    private String famille;
    private double prixachat;
    private double prixvente;

    public produit(int id, String libelle, String famille, double prixachat, double prixvente) {
        this.id = id;
        this.libelle = libelle;
        this.famille = famille;
        this.prixachat = prixachat;
        this.prixvente = prixvente;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getFamille() {
        return famille;
    }

    public double getPrixachat() {
        return prixachat;
    }

    public double getPrixvente() {
        return prixvente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public void setPrixachat(double prixachat) {
        this.prixachat = prixachat;
    }

    public void setPrixvente(double prixvente) {
        this.prixvente = prixvente;
    }
}
