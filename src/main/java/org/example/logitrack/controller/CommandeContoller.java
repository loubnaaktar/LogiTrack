package org.example.logitrack.controller;

import org.example.logitrack.model.Commande;
import org.example.logitrack.model.Produit;
import org.example.logitrack.service.CommandeService;
import org.example.logitrack.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeContoller {

    private final CommandeService commandeService;

    public CommandeContoller(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public List<Commande> allCommandes() {
        return commandeService.allCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable long id) {
        return commandeService.chercherCommandeById(id);
    }

    @PostMapping("/ajouter")
    public Commande ajouterCommande(@RequestBody int idClient) {
        return commandeService.creerCommande(idClient);
    }

    @GetMapping("/client/{idClient}")
    public List<Commande> allClientCommandes(@PathVariable int idClient) {
        return commandeService.commandeParIdClient(idClient);
    }

    @GetMapping("/count")
    public Long count() {
        return commandeService.totalCommandes();
    }

}