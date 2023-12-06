package com.example.gsneaker.repositories;

import com.example.gsneaker.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
