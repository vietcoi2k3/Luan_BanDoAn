package com.example.LuanFood.controller;

import com.example.LuanFood.entity.FoodEntity;
import com.example.LuanFood.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @RequestMapping(value = "get-all-food",method = RequestMethod.GET)
    public List<FoodEntity> getAllFood(){
        return foodRepository.findAll();
    }

    @RequestMapping(value = "find-food",method = RequestMethod.POST)
    public ResponseEntity findFoodWithId(@RequestParam Integer id){
        return ResponseEntity.ok(foodRepository.findById(id));
    }
}
