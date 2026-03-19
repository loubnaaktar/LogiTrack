package org.example.logitrack.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dateCommande;
    private String statut;
@OneToMany(mappedBy = "commande")
List<LigneCommande> ligneCommandes = new ArrayList<>();

@ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Commande(long id, LocalDateTime dateCommande, String statut, List<LigneCommande> ligneCommandes, Client client) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.statut = statut;
        this.ligneCommandes = ligneCommandes;
        this.client = client;
    }

    public Commande(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
