package com.mycompany.user_servicenew.service.impl;

import com.mycompany.user_servicenew.dto.UserDTO;
import com.mycompany.user_servicenew.entity.UserEntity;
import com.mycompany.user_servicenew.exception.BusinessException;
import com.mycompany.user_servicenew.exception.ErrorModel;
import com.mycompany.user_servicenew.repository.UserRepository;
import com.mycompany.user_servicenew.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO newUser(UserDTO userDTO)
    {
        UserEntity userEntity=new UserEntity();
         Optional<UserEntity> optionalUserEntity=userRepository.findByEmail(userDTO.getEmail());
         if(optionalUserEntity.isPresent())
         {
             List<ErrorModel> errorModels=new ArrayList<>();
             ErrorModel errorModel=new ErrorModel();
             errorModel.setCode("Email_Used");
             errorModel.setMsg("Try_Another");
             errorModels.add(errorModel);
             throw new BusinessException(errorModels);
         }
        BeanUtils.copyProperties(userDTO,userEntity);
        userEntity = userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity,userDTO);
        userDTO.setPassword(null);
        return userDTO ;
    }

    @Override
    public UserDTO loginUser(String email, String password)
    {
       Optional<UserEntity> optionalUserEntity=userRepository.findByEmailAndPassword(email,password);
       UserDTO userDTO=new UserDTO();
       if(optionalUserEntity.isPresent())
       {
           BeanUtils.copyProperties(optionalUserEntity.get(),userDTO);
           userDTO.setPassword(null);
       }
       else
       {

           List<ErrorModel> errorModels=new ArrayList<>();
           ErrorModel errorModel=new ErrorModel();
           errorModel.setCode("Enter_Correct");
           errorModel.setMsg("Not_Valid");
           errorModels.add(errorModel);
           throw new BusinessException(errorModels);
       }
        return userDTO;
    }


}
