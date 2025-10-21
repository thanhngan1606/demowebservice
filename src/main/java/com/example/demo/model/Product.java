package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Tên sản phẩm không được để troongs !")
    @Size(min = 2, max = 100, message = "Tên sản phẩm phải có từ 2 đến 100 ký tự.")
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotNull(message = "Giá sản phẩm không được để trống")
    @Positive(message = "Giá sản phẩm phải lớn hơn 0")
    @Column(name = "price", nullable = false)
    private Double price;
    
    @Size(max = 500, message = "Mô tả không được quá 500 ký tự")
    @Column(name = "description")
    private String description;
    
    @Size(max = 50, message = "Danh mục không được quá 50 ký tự")
    @Column(name = "category")
    private String category;
    
    @Column(name = "stock_quantity")
    private Integer stockQuantity = 0;

    public Product() {}
    
    public Product(String name, Double price, String description, String category, Integer stockQuantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
