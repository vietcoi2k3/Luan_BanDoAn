package com.example.LuanFood.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodRequestBill {
    private Integer quantity;
    private Integer foodId;
}
