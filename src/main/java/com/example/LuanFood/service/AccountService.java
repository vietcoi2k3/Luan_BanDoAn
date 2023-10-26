package com.example.LuanFood.service;

import com.example.LuanFood.entity.AccountEntity;
import com.example.LuanFood.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    public AccountEntity register(AccountEntity accountEntity){
        if (!accountRepository.findByUsername(accountEntity.getUsername()).isEmpty()){
            throw new RuntimeException("Tài khoản đã tồn tại");
        }
        return accountRepository.save(accountEntity);
    }

    public AccountEntity login(String username,String password){
        AccountEntity accountEntity = accountRepository.findByUsername(username).get();
        if (accountEntity!=null&&accountEntity.getPassword().contains(password)){
            accountEntity.setPassword("");
            return accountEntity;
        }
        throw new RuntimeException("tài khoản mật khẩu không đúng");
    }
}
