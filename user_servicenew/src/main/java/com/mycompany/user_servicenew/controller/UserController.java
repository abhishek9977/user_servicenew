package com.mycompany.user_servicenew.controller;

import com.mycompany.user_servicenew.dto.UserDTO;
import com.mycompany.user_servicenew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController
{

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO userDTO)
    {
        userDTO=userService.newUser(userDTO);
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("login")
    public ResponseEntity<UserDTO> userLogin(@RequestBody UserDTO userDTO)
    {
        userDTO=userService.loginUser(userDTO.getEmail(),userDTO.getPassword());
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO,HttpStatus.OK);
        return responseEntity;
    }
}
