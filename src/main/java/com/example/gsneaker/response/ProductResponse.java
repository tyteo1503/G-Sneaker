package com.example.gsneaker.response;

import com.example.gsneaker.models.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String url;
    private String name;
    private String color;

    public static ProductResponse convertToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .url(product.getUrl())
                .name(product.getName())
                .color(product.getColor())
                .build();
    }
}
