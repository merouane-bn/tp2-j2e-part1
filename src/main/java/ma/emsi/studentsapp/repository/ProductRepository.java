package ma.emsi.studentsapp.repository;
//springdata il suffit de creer une interface qui herite de interface jpa repo

import ma.emsi.studentsapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //première solution pour rechercher des produits qui contient un mot cle
    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);

    //2eme solution pour rechercher des produits qui contient un mot cle
    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x")String mc);

    @Query("select p from Product p where p.price>:x")
    List<Product> searchByPrice(@Param("x")double mc);
}
