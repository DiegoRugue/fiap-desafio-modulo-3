package com.github.diegorugue.fiapshop.products.dtos;

import com.github.diegorugue.fiapshop.products.entities.Products;

import java.io.Serializable;

public class ProductsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductsDto() {
    }

    public static ProductsDto ToDto(Products product) {
        return new ProductsDto(product.getId(), product.getName(),
                product.getPrice(), product.getDescription(), product.getImageUri());
    }

    public ProductsDto(Long id, String name, Double price, String description, String imageUri) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public ProductsDto(Products entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageUri();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUri() {
        return imageUri;
    }
}
