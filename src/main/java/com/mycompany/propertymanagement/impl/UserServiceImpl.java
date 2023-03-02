package com.mycompany.propertymanagement.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public UserDTO login(String email, String password) throws BusinessException {

        UserDTO userDTO=null;
        Optional<UserEntity> optionalUserEntity=userRepository.findByOwnerEmailAndPassword(email,password);
        if(optionalUserEntity.isPresent()){
           userDTO=userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }else{
            //add errors
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("INVALID LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }

}
