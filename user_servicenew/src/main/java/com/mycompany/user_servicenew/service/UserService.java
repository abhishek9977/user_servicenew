package com.mycompany.user_servicenew.service;


import com.mycompany.user_servicenew.dto.UserDTO;

public interface UserService
{
   public UserDTO newUser(UserDTO userDTO);
   public UserDTO loginUser(String email,String password);
}
