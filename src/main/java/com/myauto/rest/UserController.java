package com.myauto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.myauto.dto.AddUserRequest;
import com.myauto.entity.AppUser;
import com.myauto.exceptions.UserAlreadyCreatedException;
import com.myauto.ids.AppUserId;
import com.myauto.repository.UserRepository;
import com.myauto.service.UserManagement;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserManagement userManagement;

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus addUser(AddUserRequest request) {
        try {
            userManagement.addUser(request);
            return HttpStatus.OK;
        } catch (UserAlreadyCreatedException ex) {
            return HttpStatus.CONFLICT;
        }
    }
}
