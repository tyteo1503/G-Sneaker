package com.example.gsneaker.repositories;

import com.example.gsneaker.models.CartItem;
import com.example.gsneaker.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    void deleteByProduct(Product product);
    Optional<CartItem> findByProduct(Product product);
}
