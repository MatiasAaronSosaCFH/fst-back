package com.feria.tsuuki.repository;

import com.feria.tsuuki.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.isPresent = true")
    Optional<Product> findAllAvailable();

    @Query("SELECT p FROM Product p WHERE p.isPresent = true AND p.id = :id")
    Optional<Product> findProductById(@Param("id")Long id);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
    List<Product> findAllByPrice(@Param("min")Double min, @Param("max")Double max);

    @Query("SELECT p FROM Product p WHERE p.subCategory = :subCategory")
    List<Product> findProductBySubCategory(@Param("subCategory")Long subCategory);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findProductByCategory(@Param("category")Long category);

    @Modifying
    @Query("UPDATE Product p SET p.isPresent = :isPresent WHERE p.id = :id")
    Optional<Product> changeAvailable(@Param("isPresent")Boolean isPresent, @Param("id")Long id);
}
