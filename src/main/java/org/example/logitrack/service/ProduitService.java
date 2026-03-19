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

//    public void ajouterProduit(String nom, String categorie, double prix, int quantiteStock){
//        Produit produit = new Produit();
//        produit.setNom(nom);
//        produit.setCategorie(categorie);
//        produit.setPrix(prix);
//        produit.setQuantiteStock(quantiteStock);
//        produitRepository.save(produit);
//    }

      public Produit ajouterProduit(Produit produit) {
         return  produitRepository.save(produit);
      }
    public List<Produit> allProduits(){
        return produitRepository.findAll();
    }

    public Produit charcherById(long id){
        return produitRepository.findById(id).orElse(null);
    }

    public void supprimerProduit(long id){
    produitRepository.deleteById(id);
    }

}
