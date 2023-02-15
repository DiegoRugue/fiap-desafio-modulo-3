package com.github.diegorugue.fiapshop.products.controllers;

import com.github.diegorugue.fiapshop.products.dtos.CreateProductDto;
import com.github.diegorugue.fiapshop.products.dtos.ProductsDto;
import com.github.diegorugue.fiapshop.products.entities.Products;
import com.github.diegorugue.fiapshop.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping
    public List<ProductsDto> getAll() {
        return productsRepository.findAll()
                .stream()
                .map(ProductsDto::ToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDto> get(@PathVariable Long id) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(ProductsDto.ToDto(product.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductsDto create(@RequestBody CreateProductDto dto) {
        var product = productsRepository.save(dto.ToEntity());
        return ProductsDto.ToDto(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsDto> update(@PathVariable Long id, @RequestBody CreateProductDto dto) {
        if (!productsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var product = dto.ToEntity();
        product.setId(id);
        product = productsRepository.save(product);

        return ResponseEntity.ok(ProductsDto.ToDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!productsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productsRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
