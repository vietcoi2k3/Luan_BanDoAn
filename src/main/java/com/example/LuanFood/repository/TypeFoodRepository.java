package com.example.LuanFood.repository;

import com.example.LuanFood.entity.TypeFooodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeFoodRepository extends JpaRepository<TypeFooodEntity,Integer> {
}
