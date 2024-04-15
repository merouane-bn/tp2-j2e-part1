package ma.emsi.studentsapp.web;

import ma.emsi.studentsapp.entities.Product;
import ma.emsi.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    //il a besoin de interface product repo pour acceder a bdd
   //autowired pour injection de dependance
    @Autowired
    private ProductRepository productRepository;

    // creer une methode pour consulter la liste des produits
 //si on envoie une requete http avec get vers le patch
    @GetMapping("/products")
  public List<Product> Products() {
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }
}
