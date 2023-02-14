package com.github.diegorugue.fiapshop.products.dtos;

import com.github.diegorugue.fiapshop.products.entities.Products;

import java.io.Serializable;

public class CreateProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public CreateProductDto() {
    }

    public CreateProductDto(String name, Double price, String description, String imageUri) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public Products ToEntity() {
        return new Products(this.name, this.price, this.description, this.imageUri);
    }
}
