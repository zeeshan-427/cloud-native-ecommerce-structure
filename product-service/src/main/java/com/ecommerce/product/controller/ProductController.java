package com.ecommerce.product.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ApiResponse<Product> createProduct(
            @RequestBody Product product) {

        return new ApiResponse<>(
                true,
                "Product Created Successfully",
                productService.save(product)
        );
    }

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {

        return new ApiResponse<>(
                true,
                "Products Retrieved",
                productService.getAllProducts()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getProduct(
            @PathVariable("id") Long id) {

        Product product = productService.getProduct(id);

        return new ApiResponse<>(
                true,
                "Product Found",
                product
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteProduct(
            @PathVariable("id")Long id) {

        productService.deleteProduct(id);

        return new ApiResponse<>(
                true,
                "Product Deleted Successfully",
                null
        );
    }
}