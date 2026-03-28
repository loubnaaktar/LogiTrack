package org.example.logitrack.controller;

import org.example.logitrack.model.Produit;
import org.example.logitrack.service.CommandeService;
import org.example.logitrack.service.ProduitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private final CommandeService commandeService;
    private final ProduitService produitService;


    public StatisticsController(CommandeService commandeService, ProduitService produitService) {
        this.commandeService = commandeService;
        this.produitService = produitService;

    }
//    @GetMapping("/top-produit")
//    public Produit topProduit(){
//
//    }

    @GetMapping("/category/{category}")
    public List<Produit> getByCategorie(@PathVariable String category) {
        return produitService.getProduitsByCategorie(category);

    }
    @GetMapping("/prix/{prix}")
    public List<Produit> getByPrixMax(@PathVariable Double prix) {
        return produitService.getProduitsByPrixMax(prix);
    }

    @GetMapping("/low-stock")
    public List<Produit> getLowStock() {
        return produitService.getLowStockProduits();
    }
}

