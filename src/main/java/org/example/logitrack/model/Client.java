package org.example.logitrack.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String email;
    private String telephone;
    private String ville;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes = new ArrayList<>();

    public Client(long id, String nom, String email, String telephone, String ville) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
    }
    public Client(String nom, String email, String telephone, String ville) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
    }


    public Client() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
