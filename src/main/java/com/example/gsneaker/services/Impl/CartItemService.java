package com.example.gsneaker.services.Impl;

import com.example.gsneaker.common.MessageKeys;
import com.example.gsneaker.exceptions.ConstraintViolationException;
import com.example.gsneaker.exceptions.NotFoundException;
import com.example.gsneaker.exceptions.NullPointerException;
import com.example.gsneaker.models.CartItem;
import com.example.gsneaker.models.Product;
import com.example.gsneaker.repositories.CartItemRepository;
import com.example.gsneaker.repositories.ProductRepository;
import com.example.gsneaker.response.BaseResponse;
import com.example.gsneaker.response.CartItemResponse;
import com.example.gsneaker.services.ICartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService {
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public BaseResponse<List<CartItemResponse>> getCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        List<CartItemResponse> cartItemResponses = cartItems.stream()
                .map(CartItemResponse::convertToCartItemResponse).toList();
        return BaseResponse.<List<CartItemResponse>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message(MessageKeys.GET_SUCCESS)
                .data(cartItemResponses)
                .build();
    }
    @Override
    public BaseResponse<Void> insertCartItem(Integer productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(MessageKeys.PRODUCT_NOT_FOUND));
        Optional<CartItem> existingCartItem = cartItemRepository.findByProduct(existingProduct);
        if (existingCartItem.isPresent()){
            throw new ConstraintViolationException(MessageKeys.PRODUCT_ALREADY_IN_CART);
        }
        CartItem cartItem = CartItem.builder()
                .product(existingProduct)
                .quantity(1)
                .build();
        cartItemRepository.save(cartItem);
        return BaseResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message(MessageKeys.INSERTED_SUCCESS)
                .build();
    }

    @Override
    @Transactional
    public BaseResponse<Void> updateCartItem(Integer productId, Integer changeAmount) {
        if (changeAmount == null){
            throw new NullPointerException(MessageKeys.REQUIRED_PARAMETER_NOT_NULL);
        }
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(MessageKeys.PRODUCT_NOT_FOUND));
        CartItem existingCartItem = cartItemRepository.findByProduct(existingProduct)
                .orElseThrow(() -> new ConstraintViolationException(MessageKeys.PRODUCT_NOT_EXISTING_IN_CART));
            int newQuantity = changeAmount + existingCartItem.getQuantity();
        if (newQuantity <= 0){
            cartItemRepository.delete(existingCartItem);
        }else {
            existingCartItem.setQuantity(newQuantity);
            cartItemRepository.save(existingCartItem);
        }
        return BaseResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message(MessageKeys.UPDATED_SUCCESS)
                .build();
    }

    @Override
    @Transactional
    public BaseResponse<Void> deleteCartItem(Integer productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(MessageKeys.PRODUCT_NOT_FOUND));
        CartItem cartItem = cartItemRepository.findByProduct(existingProduct)
                .orElseThrow(() -> new NotFoundException(MessageKeys.PRODUCT_NOT_EXISTING_IN_CART));
        cartItemRepository.deleteByProduct(existingProduct);
        return BaseResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message(MessageKeys.DELETED_SUCCESS)
                .build();
    }
}
