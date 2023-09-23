package com.example.LuanFood.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameFood;
    private String imgFood;
    private String detail;
    private int price;

    @Column(name = "typeFoodId")
    private Integer typeFoodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeFoodId",insertable = false,updatable = false)
    @JsonBackReference("food-type")
    private TypeFooodEntity typeFoodEntity;

    @OneToMany(mappedBy = "foodEntity")
    @JsonManagedReference(value = "food-orderDetail")
    private List<OrderDetailEntity> orderDetailEntities;
}
