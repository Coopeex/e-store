package com.example.estore.service;

import com.example.estore.model.Product;
import com.example.estore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    // Retrieve all products (for admin)
    public List<Product> getAllProductsByAdmin() {
        return productRepository.findAll();
    }
    // Retrieve all products with optional parameters (limit, sort, category)
    public List<Product> getAllProducts(int limit, String sort, String category) {
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be greater than zero.");
        }

        if (!sort.equalsIgnoreCase("asc") && !sort.equalsIgnoreCase("desc")) {
            throw new IllegalArgumentException("Sort parameter must be 'asc' or 'desc'.");
        }

        List<Product> products;

        if (category != null && !category.isEmpty()) {
            if (category.equalsIgnoreCase("All")) {
                products = productRepository.findAll();
            } else {
                products = productRepository.findByCategory(category);
            }
        } else {
            products = productRepository.findAll();
        }

        // Sort by price
        if (sort.equalsIgnoreCase("asc")) {
            products.sort(Comparator.comparing(Product::getPrice));
        } else if (sort.equalsIgnoreCase("desc")) {
            products.sort(Comparator.comparing(Product::getPrice).reversed());
        }

        // Apply limit
        if (limit > 0 && limit < products.size()) {
            products = products.subList(0, limit);
        }

        return products;
    }
    // Retrieve all categories of products
    public List<String> findAllCategories(String sort) {
        List<Product> products = productRepository.findAll();

        List<String> categories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .collect(Collectors.toList());

        if (sort.equalsIgnoreCase("asc")) {
            categories.sort(Comparator.naturalOrder());
        } else if (sort.equalsIgnoreCase("desc")) {
            categories.sort(Comparator.reverseOrder());
        }

        categories.add(0, "All");

        return categories;
    }
    // Add a new product
    public List<Product> addNewProduct(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }
    // Delete a product by its ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
    // Update a product by its ID
    public void updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        existingProduct.setTitle(product.getTitle());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImage(product.getImage());

        productRepository.save(existingProduct);
    }
}


