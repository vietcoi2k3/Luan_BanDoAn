package com.example.LuanFood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TypeFooodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameType;
    private String imgType;

    @OneToMany(mappedBy = "typeFoodEntity")
    @JsonManagedReference(value = "food-type")
    @JsonIgnore
    private List<FoodEntity> foodEntityList;
}
