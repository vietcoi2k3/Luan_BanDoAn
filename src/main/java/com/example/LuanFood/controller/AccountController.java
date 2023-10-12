package com.example.LuanFood.controller;

import com.example.LuanFood.entity.AccountEntity;
import com.example.LuanFood.repository.AccountRepository;
import com.example.LuanFood.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody AccountEntity accountEntity){
        return ResponseEntity.ok(accountService.register(accountEntity));
    }

    @Operation(summary = "chỉ cần truyền tài khoản mật khẩu")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody AccountEntity accountEntity){
        return ResponseEntity.ok(accountService.login(accountEntity.getUsername(),accountEntity.getPassword()));
    }

    @RequestMapping(value = "get-userinfo",method = RequestMethod.GET)
    public ResponseEntity getUserInfo(@RequestParam Integer accountId){
        return ResponseEntity.ok(accountRepository.findById(accountId));
    }
}