package org.example.logitrack.controller;

import org.example.logitrack.model.Commande;
import org.example.logitrack.service.CommandeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeContoller {

    private final CommandeService commandeService;

    public CommandeContoller(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public List<Commande> allCommandes(){
        return commandeService.allCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(long id){
        return commandeService.chercherCommandeById(id);
    }



}
