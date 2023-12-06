package com.example.gsneaker.services;

import com.example.gsneaker.models.Product;
import com.example.gsneaker.response.BaseResponse;

import java.util.List;

public interface IProductService {
    BaseResponse<List<Product>> getProducts();
}
