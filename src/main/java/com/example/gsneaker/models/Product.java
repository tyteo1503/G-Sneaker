package com.example.gsneaker.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "image_url")
    @NotNull
    private String url;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private String color;
}
