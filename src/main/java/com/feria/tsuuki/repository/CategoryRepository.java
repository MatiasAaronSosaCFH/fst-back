package com.feria.tsuuki.repository;

import com.feria.tsuuki.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM Category c WHERE c.isPresent = true")
    List<Category> findAllAvailable();

    @Query("SELECT c FROM Category c WHERE c.name = :name")
    Optional<Category> fingCategoryByName(@Param("name")String name);

    @Query("SELECT c FROM Category c WHERE c.id = :id")
    Optional<Category> findCategoryById(@Param("id")Long id);

    @Modifying
    @Query("UPDATE Category c SET c.isPresent = :isPresent WHERE c.id = :id")
    Optional<Category> changeAvailable(@Param("id")Long id, @Param("isPresent")Boolean isPresent);

    @Modifying
    @Query("UPDATE Category c SET c.name = :name WHERE c.id = :id")
    Optional<Category> updateCategory(@Param("name")String name, @Param("id")Long id);
}
