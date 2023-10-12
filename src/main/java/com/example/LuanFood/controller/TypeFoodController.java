package com.example.LuanFood.controller;

import com.example.LuanFood.repository.TypeFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeFoodController {
    @Autowired
    private TypeFoodRepository typeFoodRepository;
    @RequestMapping(value = "get-all-type",method = RequestMethod.GET)
    public ResponseEntity getAllType(){
        return ResponseEntity.ok(typeFoodRepository.findAll());
    }
}
