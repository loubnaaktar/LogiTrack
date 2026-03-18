package org.example.logitrack.service;

import org.example.logitrack.model.Produit;
import org.example.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public void ajouterProduit(Produit produit){
        produitRepository.save(produit);
    }

    public List<Produit> allProduits(){
        return produitRepository.findAll();
    }

    public Produit charcherById(int id){
        return produitRepository.findById(id).orElse(null);
    }

    public void supprimerProduit(int id){
        produitRepository.deleteById(id);
    }

}
