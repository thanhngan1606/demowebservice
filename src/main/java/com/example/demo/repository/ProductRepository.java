package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findByNameContainingIgnoreCase(String name);
    
    List<Product> findByCategoryIgnoreCase(String category);
    
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    
    List<Product> findByStockQuantityGreaterThan(Integer stockQuantity);
    
    List<Product> findByStockQuantity(Integer stockQuantity);
    
    @Query("SELECT p FROM Product p WHERE " +
           "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
           "(:category IS NULL OR LOWER(p.category) LIKE LOWER(CONCAT('%', :category, '%'))) AND " +
           "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
           "(:maxPrice IS NULL OR p.price <= :maxPrice)")
    List<Product> searchProducts(@Param("name") String name, 
                                 @Param("category") String category,
                                 @Param("minPrice") Double minPrice, 
                                 @Param("maxPrice") Double maxPrice);
    
    @Query("SELECT DISTINCT p.category FROM Product p WHERE p.category IS NOT NULL")
    List<String> findAllCategories();
    
    long countByCategoryIgnoreCase(String category);
}
