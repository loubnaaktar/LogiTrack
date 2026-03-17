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
    private int id;
    private LocalDateTime dateCommande;
    private String statut;
@OneToMany(mappedBy = "commande")
List<LigneCommande> ligneCommandes = new ArrayList<>();

@ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
