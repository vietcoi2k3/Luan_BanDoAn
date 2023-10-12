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
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String adress;

    @OneToMany(mappedBy = "accountEntity")
    @JsonManagedReference(value = "account-order")
    @JsonIgnore
    private List<OrderEntity> orderEntityList;
}
