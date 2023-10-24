package com.example.LuanFood.controller;

import com.example.LuanFood.entity.AccountEntity;
import com.example.LuanFood.repository.AccountRepository;
import com.example.LuanFood.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody AccountEntity accountEntity){
        try {
            accountService.register(accountEntity);
            return ResponseEntity.ok("đăng kí thành công");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

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

    @Operation(summary = "phải truyền id,fullname,adress,std, không cần truyền những thứ còn lại")
    @RequestMapping(value = "update-user-info",method = RequestMethod.PUT)
    public ResponseEntity updateUserInfo(@RequestBody AccountEntity account){
        AccountEntity accountEntity = accountRepository.findById(account.getId()).get();
        accountEntity.setAddress(account.getAddress());
        accountEntity.setFullname(account.getFullname());
        accountEntity.setStd(account.getStd());
        return ResponseEntity.ok(accountRepository.save(accountEntity));
    }
}
