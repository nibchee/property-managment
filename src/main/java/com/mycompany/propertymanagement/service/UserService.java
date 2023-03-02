package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.exception.BusinessException;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email,String password) throws BusinessException;
}
