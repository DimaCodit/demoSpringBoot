package com.example.demospringboot.service;

import com.example.demospringboot.dto.ProductDto;
import com.example.demospringboot.repository.ProductRepository;
import com.example.demospringboot.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        log.debug("find all");
        return productRepository.findAll().stream().map(ConverterUtil::productToDto).collect(Collectors.toUnmodifiableList());
    }

    public void add(ProductDto product) {
        log.debug("add product");
        productRepository.saveOrUpdate(ConverterUtil.dtoToProduct(product));
    }
}
