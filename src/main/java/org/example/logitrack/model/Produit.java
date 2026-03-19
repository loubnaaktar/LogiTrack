package org.example.logitrack.model;
//
import jakarta.persistence.*;
//
//@Entity
//@Table(name = "produits")
//public class Produit {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String nom;
//    private String categorie;
//    private double prix;
//    private int quantiteStock;
//
//    @ManyToOne
//    private LigneCommande lignecommande;
//
//
//    public Produit(int id, String nom, String categorie, double prix, int quantiteStock) {
//        this.id = id;
//        this.nom = nom;
//        this.categorie = categorie;
//        this.prix = prix;
//        this.quantiteStock = quantiteStock;
//    }
//
//    public Produit() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getCategorie() {
//        return categorie;
//    }
//
//    public void setCategorie(String categorie) {
//        this.categorie = categorie;
//    }
//
//    public double getPrix() {
//        return prix;
//    }
//
//    public void setPrix(double prix) {
//        this.prix = prix;
//    }
//
//    public int getQuantiteStock() {
//        return quantiteStock;
//    }
//
//    public void setQuantiteStock(int quantiteStock) {
//        this.quantiteStock = quantiteStock;
//    }
//
//    public LigneCommande getLignecommande() {
//        return lignecommande;
//    }
//
//    public void setLignecommande(LigneCommande lignecommande) {
//        this.lignecommande = lignecommande;
//    }
//}


import jakarta.persistence.GeneratedValue;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;


    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> ligneCommandeList = new ArrayList<>();

    public Produit() {}

    public Produit(long id, String nom, String categorie, double prix, int quantiteStock) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    public Produit(String nom, String categorie, double prix, int quantiteStock, List<LigneCommande> ligneCommandeList) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.ligneCommandeList = ligneCommandeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public List<LigneCommande> getLigneCommandeList() {
        return ligneCommandeList;
    }

    public void setLigneCommandeList(List<LigneCommande> ligneCommandeList) {
        this.ligneCommandeList = ligneCommandeList;
    }
}