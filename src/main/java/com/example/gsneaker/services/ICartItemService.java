package com.example.gsneaker.services;

import com.example.gsneaker.models.CartItem;
import com.example.gsneaker.models.Product;
import com.example.gsneaker.response.BaseResponse;
import com.example.gsneaker.response.CartItemResponse;

import java.util.List;

public interface ICartItemService {
    BaseResponse<List<CartItemResponse>> getCartItems();
    BaseResponse<Void> insertCartItem(Integer productId);
    BaseResponse<Void> updateCartItem(Integer productId, Integer quantity);
    BaseResponse<Void> deleteCartItem(Integer productId);
}
