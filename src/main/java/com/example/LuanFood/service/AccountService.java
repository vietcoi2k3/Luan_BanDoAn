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
            return null;
        }
        return accountRepository.save(accountEntity);
    }

    public String login(String username,String password){
        AccountEntity accountEntity = accountRepository.findByUsername(username).get();
        if (accountEntity!=null&&accountEntity.getPassword().contains(password)){
            return "Đăng nhập thành công";
        }
        return "tài khoản hoặc mật khẩu không đúng";
    }
}
