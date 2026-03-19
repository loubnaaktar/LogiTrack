package org.example.logitrack.controller;

import org.example.logitrack.model.Produit;
import org.example.logitrack.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    final private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> listproduits(){
        return produitService.allProduits();
    }
    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable int id){
        return produitService.charcherById(id);
    }

    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit){
      return produitService.ajouterProduit(produit);
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable long id){
        produitService.supprimerProduit(id);
    }
}

