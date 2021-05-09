package com.example.demospringboot.util;

import com.example.demospringboot.dto.ProductDto;
import com.example.demospringboot.model.Product;

public class ConverterUtil {

    public static Product dtoToProduct(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost(), false);
    }

    public static ProductDto productToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
}
