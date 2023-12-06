package com.example.gsneaker.services.Impl;

import com.example.gsneaker.common.MessageKeys;
import com.example.gsneaker.models.Product;
import com.example.gsneaker.repositories.ProductRepository;
import com.example.gsneaker.response.BaseResponse;
import com.example.gsneaker.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Override
    public BaseResponse<List<Product>> getProducts() {
        List<Product> products = productRepository.findAll();
        return BaseResponse.<List<Product>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message(MessageKeys.GET_SUCCESS)
                .data(products)
                .build();
    }
}
