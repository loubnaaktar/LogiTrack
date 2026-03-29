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

    public Produit getTopProduit() {
        return produitRepository
                .findTopOrderedProducts()
                .stream()
                .findFirst()
                .orElse(null);
    }
    public List<Produit> getLowStockProduits() {
        return produitRepository.findLowStockProducts(5);
    }

    public List<Produit> getProduitsByPrixMax(Double prix) {
        return produitRepository.findByPrixLessThanEqual(prix);
    }

    public List<Produit> getProduitsByCategorie(String categorie) {
        return produitRepository.findByCategorieIgnoreCase(categorie);
    }
}
