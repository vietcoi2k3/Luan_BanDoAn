package com.example.LuanFood.repository;

import com.example.LuanFood.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Integer> {
    public Optional<AccountEntity> findByUsername(String username);
}
