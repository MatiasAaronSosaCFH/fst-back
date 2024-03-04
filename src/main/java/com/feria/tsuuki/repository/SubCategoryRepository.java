package com.feria.tsuuki.repository;

import com.feria.tsuuki.models.subcategory.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    @Query("SELECT sb FROM SubCategory sb WHERE sb.id = :id AND sb.isPresent = true")
    Optional<SubCategory> findSubCategoryById(@Param("id")Long id);
}
