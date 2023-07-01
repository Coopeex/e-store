package com.example.estore.config;

import com.example.estore.model.Product;
import com.example.estore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product[] products = {
                    new Product("Killer", 500.0, "Sinking", "9cm best salmon killer", "https://th.bing.com/th/id/OIP.XK5Fl6ekftrzXyMvjlNbowHaHa?w=187&h=187&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Striper", 450.0, "Floating", "9cm best trout killer", "https://th.bing.com/th/id/OIP.AryJYGSG6m9ukP4iT6yB1gHaFj?pid=ImgDet&rs=1"),
                    new Product("Akara", 350.0, "Suspending", "9cm best pike killer", "https://th.bing.com/th/id/OIP.r77CeJ2UhsUKStURT3AIvgHaFj?pid=ImgDet&rs=1"),
                    new Product("JPDCr", 600.0, "Sinking", "9cm best salmon lure", "https://th.bing.com/th/id/OIP.cugDAXyOM_Y5sGIWVkZkfAHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Lombret", 100.0, "Floating", "9cm best fresh water", "https://th.bing.com/th/id/OIP.DsbavTdkzXVfJnfnk78b7QHaFB?w=279&h=189&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Warterer", 550.0, "Suspending", "8cm stream", "https://th.bing.com/th/id/OIP.W85YmMJoIwYqx7V_5KIsowHaHa?w=198&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Sirkere", 200.0, "Sinking", "7cm small game", "https://th.bing.com/th/id/OIP.1ZIenkhSicWrKteLU6BirgHaDq?w=346&h=173&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Labnaz", 250.0, "Floating", "9cm best sea", "https://th.bing.com/th/id/OIP.i-WF1uQpwKqfCjxo1It2cAHaHa?w=197&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Rertr", 150.0, "Suspending", "15cm best pike", "https://th.bing.com/th/id/OIP._lYUlJNLaC6OhvanAsCuswD6D6?w=201&h=201&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Killer", 700.0, "Sinking", "9cm best salmon killer", "https://th.bing.com/th/id/OIP.XK5Fl6ekftrzXyMvjlNbowHaHa?w=187&h=187&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Striper", 750.0, "Floating", "9cm best trout killer", "https://th.bing.com/th/id/OIP.AryJYGSG6m9ukP4iT6yB1gHaFj?pid=ImgDet&rs=1"),
                    new Product("Akara", 650.0, "Suspending", "9cm best pike killer", "https://th.bing.com/th/id/OIP.r77CeJ2UhsUKStURT3AIvgHaFj?pid=ImgDet&rs=1"),
                    new Product("JPDCr", 220.0, "Sinking", "9cm best salmon lure", "https://th.bing.com/th/id/OIP.cugDAXyOM_Y5sGIWVkZkfAHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Lombret", 320.0, "Floating", "9cm best fresh water", "https://th.bing.com/th/id/OIP.DsbavTdkzXVfJnfnk78b7QHaFB?w=279&h=189&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Warterer", 230.0, "Suspending", "8cm stream", "https://th.bing.com/th/id/OIP.W85YmMJoIwYqx7V_5KIsowHaHa?w=198&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Sirkere", 542.0, "Sinking", "7cm small game", "https://th.bing.com/th/id/OIP.1ZIenkhSicWrKteLU6BirgHaDq?w=346&h=173&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Labnaz", 351.0, "Floating", "9cm best sea", "https://th.bing.com/th/id/OIP.i-WF1uQpwKqfCjxo1It2cAHaHa?w=197&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
                    new Product("Rertr", 456.0, "Suspending", "15cm best pike", "https://th.bing.com/th/id/OIP._lYUlJNLaC6OhvanAsCuswD6D6?w=201&h=201&c=7&r=0&o=5&dpr=1.3&pid=1.7"),
            };
            for (Product product : products) {
                productRepository.save(product);
            }
        };
    }
}
