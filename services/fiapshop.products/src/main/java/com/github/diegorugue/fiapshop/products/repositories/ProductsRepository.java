package com.github.diegorugue.fiapshop.products.repositories;

import com.github.diegorugue.fiapshop.products.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
