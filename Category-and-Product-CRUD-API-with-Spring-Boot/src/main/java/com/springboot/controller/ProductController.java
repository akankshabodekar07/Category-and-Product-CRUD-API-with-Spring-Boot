
package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.entity.Product;
import com.springboot.repository.CategoryRepository;
import com.springboot.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (!categoryRepo.existsById(product.getCategory().getId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productRepo.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        if (productRepo.existsById(id) && categoryRepo.existsById(product.getCategory().getId())) {
            product.setId(id);
            return ResponseEntity.ok(productRepo.save(product));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

