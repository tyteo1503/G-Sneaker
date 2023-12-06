package com.example.gsneaker.controllers;

import com.example.gsneaker.models.CartItem;
import com.example.gsneaker.response.BaseResponse;
import com.example.gsneaker.response.CartItemResponse;
import com.example.gsneaker.services.Impl.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.prefix}/cart")
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;
    @GetMapping("items")
    public ResponseEntity<BaseResponse<List<CartItemResponse>>> getCartItem(){
        BaseResponse<List<CartItemResponse>> response = cartItemService.getCartItems();
        return ResponseEntity.ok(response);
    }
    @PostMapping("add-item/{product_id}")
    public ResponseEntity<BaseResponse<Void>> insertCartItem(
            @PathVariable("product_id") Integer productId
    ){
        BaseResponse<Void> response = cartItemService.insertCartItem(productId);
        return ResponseEntity.ok(response);
    }
    @PutMapping("update-item/{product_id}")
    public ResponseEntity<BaseResponse<Void>> updateCartItem(
            @PathVariable("product_id") Integer productId,
            @RequestParam("change_amount") Optional<Integer> changeAmount
    ){
        BaseResponse<Void> response = cartItemService.updateCartItem(productId,changeAmount.orElse(null));
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("delete-item/{product_id}")
    public ResponseEntity<BaseResponse<Void>> deleteCateItem(
            @PathVariable("product_id") Integer productId
    ){
        BaseResponse<Void> response = cartItemService.deleteCartItem(productId);
        return ResponseEntity.ok(response);
    }
}
