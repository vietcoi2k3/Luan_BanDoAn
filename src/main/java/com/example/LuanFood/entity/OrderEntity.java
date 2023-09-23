package com.example.LuanFood.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int totalAmount;
    private String orderBy;
    private Date finishDate;
    @Column(name = "accountId")
    private Integer accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId",insertable = false,updatable = false)
    @JsonBackReference(value = "account-order")
    private AccountEntity accountEntity;

    @OneToMany(mappedBy = "orderEntity")
    @JsonManagedReference(value = "")
    private List<OrderDetailEntity> orderDetailEntities;
}
