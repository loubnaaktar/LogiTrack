package org.example.logitrack.service;

import org.example.logitrack.model.Client;
import org.example.logitrack.model.Commande;
import org.example.logitrack.model.LigneCommande;
import org.example.logitrack.model.Produit;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.repository.CommandeRepository;
import org.example.logitrack.repository.LigneCommandeRepository;
import org.example.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService {

   private final CommandeRepository commandeRepository;
   private final ProduitService produitService;
   private final ClientService clientService;
    private final LigneCommandeRepository ligneCommandeRepository;

    public CommandeService(CommandeRepository commandeRepository, ProduitService produitService, ClientService clientService, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
       this.produitService = produitService;
       this.clientService = clientService;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    public List<Commande> allCommandes(){
        return commandeRepository.findAll();
    }

    public Commande chercherCommandeById(long id){
        return commandeRepository.findById(id).orElse(null);
    }

    public Commande creerCommande(int idClient){
        Client client= clientService.chercherClientById(idClient);
        Commande commande =new Commande();
        commande.setDateCommande(LocalDateTime.now());
        commande.setClient(client);
        client.getCommandes().add(commande);
        return commandeRepository.save(commande);
    }


    public LigneCommande ajouterProduitCommande(int idCommande, int idProduit, int quantite) throws Exception {
       Commande commande = chercherCommandeParId(idCommande);
       Produit produit = produitService.charcherById(idProduit);
       if(produit.getQuantiteStock() < quantite){
           throw new Exception("Stock insuffisant");
       }
       produit.setQuantiteStock(produit.getQuantiteStock() - quantite);

       LigneCommande ligneCommande = new LigneCommande();
       ligneCommande.setQuantite(quantite);
       ligneCommande.setCommande(commande);
       ligneCommande.setProduit(produit);

       return ligneCommandeRepository.save(ligneCommande);
    }

    public Commande chercherCommandeParId(long idCommande){
        return commandeRepository.findById(idCommande).orElse(null);
    }

    public Commande updateStatut(int idCommande , String statut){
        Commande commande = chercherCommandeParId(idCommande);
        commande.setStatut(statut);

        return commandeRepository.save(commande);
    }

//    public List<Commande> commandeParIdClient(long idClient){
//        clientService.chercherClientById(idClient);
//        return commandeRepository.CommandeParIdClient(idClient);
//    }

    public List<Commande> commandeParIdClient(long idClient){
        Client client  = clientService.chercherClientById(idClient);
        return client.getCommandes();
    }

    public Long totalCommandes(){
        return commandeRepository.count();
    }
}
