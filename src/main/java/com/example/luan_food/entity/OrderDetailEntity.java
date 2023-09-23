package com.example.luan_food.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;
    @Column(name = "foodId")
    private Integer foodId;
    @Column(name = "orderId")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodId",insertable = false,updatable = false)
    @JsonBackReference(value = "food-orderDetail")
    private FoodEntity foodEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId",insertable = false,updatable = false)
    @JsonBackReference(value = "orderDetail-order")
    private OrderEntity orderEntity;
}
