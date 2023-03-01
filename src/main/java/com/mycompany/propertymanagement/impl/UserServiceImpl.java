package com.mycompany.propertymanagement.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity= userConverter.convertDTOtoEntity(userDTO);
        userRepository.save(userEntity);
        userDTO=userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {

        UserDTO userDTO=null;
        Optional<UserEntity> optionalUserEntity=userRepository.findByOwnerEmailAndPassword(email,password);
        if(optionalUserEntity.isPresent()){
           userDTO=userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }
        return userDTO;
    }
}
