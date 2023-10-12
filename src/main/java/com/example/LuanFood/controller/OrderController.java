package com.example.LuanFood.controller;

import com.example.LuanFood.DTO.OrderRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @RequestMapping(value = "add-bill",method = RequestMethod.POST)
    public ResponseEntity addBill(@RequestBody OrderRequestDTO orderRequestDTO){

        return ResponseEntity.ok();
    }
}
