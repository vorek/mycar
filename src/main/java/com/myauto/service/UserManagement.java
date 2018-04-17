package com.myauto.service;

import com.myauto.dto.AddUserRequest;
import com.myauto.exceptions.UserAlreadyCreatedException;

public interface UserManagement {

    void addUser(AddUserRequest request) throws UserAlreadyCreatedException;
}
