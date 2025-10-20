package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    public Product createProduct(Product product) {
        if (product.getStockQuantity() == null) {
            product.setStockQuantity(0);
        }
        return productRepository.save(product);
    }
    
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));
        
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        product.setCategory(productDetails.getCategory());
        product.setStockQuantity(productDetails.getStockQuantity());
        
        return productRepository.save(product);
    }
    
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));
        
        productRepository.delete(product);
    }
    
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }
    
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
    
    public List<Product> getProductsInStock(Integer stockQuantity) {
        return productRepository.findByStockQuantityGreaterThan(stockQuantity);
    }
    
    public List<Product> getOutOfStockProducts() {
        return productRepository.findByStockQuantity(0);
    }
    
    public List<Product> searchProducts(String name, String category, Double minPrice, Double maxPrice) {
        return productRepository.searchProducts(name, category, minPrice, maxPrice);
    }
    
    public List<String> getAllCategories() {
        return productRepository.findAllCategories();
    }
    
    public long countProductsByCategory(String category) {
        return productRepository.countByCategoryIgnoreCase(category);
    }
    
    public boolean productExists(Long id) {
        return productRepository.existsById(id);
    }
    
    public Product updateStockQuantity(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));
        
        product.setStockQuantity(quantity);
        return productRepository.save(product);
    }
}
