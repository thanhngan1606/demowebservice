package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class DemoWebServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoWebServiceApplication.class, args);
        System.out.println("Demo Web Service đã khởi động thành công!");
        System.out.println("Truy cập: http://localhost:8080/api/products");
        System.out.println("H2 Console: http://localhost:8080/h2-console");
    }
}
