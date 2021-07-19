package com.example.demo.controller;

import com.example.demo.dto.UserInfo;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;


    @ApiOperation(value = "회원정보 리스트 가져오기", response = List.class)
    @GetMapping
    public ResponseEntity<List<UserInfo>> getListUserInfo(){
        return new ResponseEntity<List<UserInfo>>(userServiceImpl.selectUser(), HttpStatus.OK);
    }

    @ApiOperation(value = "로그인할때 사용", response = String.class)
    @GetMapping("/login")
    public ResponseEntity<String> getUserLogin(@RequestParam String id, @RequestParam String pw){
        System.out.println(userServiceImpl.selectUserByIdAndPw(id, pw).getUserId());
        if(userServiceImpl.selectUserByIdAndPw(id, pw) != null){
            return new ResponseEntity<String>("로그인 완료", HttpStatus.OK);
        }
        return new ResponseEntity<String>("로그인 실패", HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "회원정보 리스트 가져오기", response = String.class)
    @PostMapping
    public ResponseEntity<String> insertUser(@RequestBody UserInfo userInfo){
        return userServiceImpl.insertUser(userInfo) ? new ResponseEntity<String>("등록성공", HttpStatus.OK)
                : new ResponseEntity<String> ("등록실패", HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "회원정보 리스트 가져오기", response = String.class)
    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserInfo userInfo){
        return userServiceImpl.updateUser(userInfo) ? new ResponseEntity<String>("등록성공", HttpStatus.OK)
                : new ResponseEntity<String> ("등록실패", HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "회원정보 리스트 가져오기", response = String.class)
    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody UserInfo userInfo){
        return userServiceImpl.deleteUser(userInfo) ? new ResponseEntity<String>("등록성공", HttpStatus.OK)
                : new ResponseEntity<String> ("등록실패", HttpStatus.NOT_FOUND);
    }
}
