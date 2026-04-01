package com.inventory.inventorysystem.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.inventory.inventorysystem.model.Product;
import com.inventory.inventorysystem.repository.ProductRepository;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo)
    {
        this.repo = repo;
    }

    @GetMapping
    public List<Product> getProducts()
    {
        return repo.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product)
    {
        return repo.save(product);
    }
    @PutMapping("/{id}")

public Product updateProduct(@PathVariable Long id,
                             @RequestBody Product product)
{

product.setId(id);

return repo.save(product);

}

}