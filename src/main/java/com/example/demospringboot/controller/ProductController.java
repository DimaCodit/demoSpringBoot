package com.example.demospringboot.controller;

import com.example.demospringboot.dto.ProductDto;
import com.example.demospringboot.model.Product;
import com.example.demospringboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @PostMapping
    public String add(@ModelAttribute ProductDto product) {
        productService.add(product);
        return "productAdded";
    }

}
