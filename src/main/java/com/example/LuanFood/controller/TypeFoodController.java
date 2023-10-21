package com.example.LuanFood.controller;

import com.example.LuanFood.repository.TypeFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TypeFoodController {
    @Autowired
    private TypeFoodRepository typeFoodRepository;
    @RequestMapping(value = "get-all-type",method = RequestMethod.GET)
    public ResponseEntity getAllType(){
        return ResponseEntity.ok(typeFoodRepository.findAll());
    }

    @RequestMapping(value = "find-type",method = RequestMethod.POST)
    public ResponseEntity findTypeWithId(@RequestParam Integer id){
        return ResponseEntity.ok(typeFoodRepository.findById(id));
    }
}
