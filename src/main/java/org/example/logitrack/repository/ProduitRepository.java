package org.example.logitrack.repository;

import org.example.logitrack.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

    @Query("SELECT lc.produit FROM LigneCommande lc GROUP BY lc.produit ORDER BY SUM(lc.quantite) DESC")
    List<Produit> findTopOrderedProducts();

    @Query("SELECT p FROM Produit p WHERE p.quantiteStock < :seuil")
    List<Produit> findLowStockProducts(@Param("seuil") int seuil);

    List<Produit> findByPrixLessThanEqual(Double prix);

    List<Produit> findByCategorieIgnoreCase(String categorie);
}
