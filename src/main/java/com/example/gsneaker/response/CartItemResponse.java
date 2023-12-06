package com.example.gsneaker.response;

import com.example.gsneaker.models.CartItem;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemResponse {
    private Integer id;
    private ProductResponse productResponse;
    private Integer quantity;

    public static CartItemResponse convertToCartItemResponse(CartItem cartItem){
        return CartItemResponse.builder()
                .id(cartItem.getId())
                .productResponse(ProductResponse.convertToProductResponse(cartItem.getProduct()))
                .quantity(cartItem.getQuantity())
                .build();
    }
}
