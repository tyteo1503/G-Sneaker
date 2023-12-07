package com.example.gsneaker.controllers;

import com.example.gsneaker.models.Product;
import com.example.gsneaker.response.BaseResponse;
import com.example.gsneaker.services.Impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/products")
@CrossOrigin(origins = "http://localhost:5500")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Product>>> getProducts(){
        BaseResponse<List<Product>> response = productService.getProducts();
        return ResponseEntity.ok(response);
    }
}
