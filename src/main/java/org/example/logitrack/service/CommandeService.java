package org.example.logitrack.service;

import org.example.logitrack.model.Client;
import org.example.logitrack.model.Commande;
import org.example.logitrack.model.Produit;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.repository.CommandeRepository;
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

    public CommandeService(CommandeRepository commandeRepository,ProduitService produitService, ClientService clientService) {
        this.commandeRepository = commandeRepository;
       this.produitService = produitService;
       this.clientService = clientService;

    }

    public List<Commande> allCommandes(){
        return commandeRepository.findAll();
    }

    public Commande chercherCommandeById(int id){
        return commandeRepository.findById(id).orElse(null);
    }

//    public void creerCommande(List<Integer> idproduits, int idClient, int quantite) {
//
//        List<Produit> produitsChoisis = new ArrayList<>();
//
//        for (int i = 0; i < idproduits.size(); i++) {
//            int idproduit = idproduits.get(i);
//
//            Produit produit = produitService.charcherById(idproduit);
//
//            if (produit != null) {
//                produitsChoisis.add(produit);
//            }
//        }
//
//        Client client = clientService.chercherClientById(idClient);
//
//        Commande commande = new Commande();
//    }

    public void creerCommande(int idClient){
        Client client= clientService.chercherClientById(idClient);
        Commande commande =new Commande();
        commande.setDateCommande(LocalDateTime.now());
        commande.setClient(client);
        client.getCommandes().add(commande);
    }


}
