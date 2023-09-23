package com.example.LuanFood.controller;

import com.example.LuanFood.entity.FoodEntity;
import com.example.LuanFood.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @RequestMapping(value = "get-all-food",method = RequestMethod.GET)
    public List<FoodEntity> getAllFood(){
        return foodRepository.findAll();
    }
}
