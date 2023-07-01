package com.example.estore.controller;


import com.example.estore.model.Product;
import com.example.estore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;
    // Retrieve all products (for admin)
    @GetMapping("/admin")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getAllProductsByAdmin(){
        return productService.getAllProductsByAdmin();
    }
    // Retrieve all products with optional parameters (limit, sort, category)
    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getAllProducts(@RequestParam(value = "limit", defaultValue = "12") int limit,
                                        @RequestParam(value = "sort", defaultValue = "asc") String sort,
                                        @RequestParam(value = "category", defaultValue = "All") String category) {
        return productService.getAllProducts(limit, sort, category);
    }
    // Retrieve all categories of products
    @GetMapping("/categories")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<String> getAllCategories(@RequestParam(value = "sort", defaultValue = "asc") String sort) {
        return productService.findAllCategories(sort);
    }
    // Add a new product
    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addNewProduct(@RequestBody Product product) {
        List<Product> products = productService.addNewProduct(product);
    }
    // Delete a product by its ID
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteProductByTitle(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
    // Update a product by its ID
    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }
}



