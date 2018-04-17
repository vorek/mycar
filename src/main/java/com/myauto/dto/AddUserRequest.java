package com.myauto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {

    private String name;
    
    private String email;
    
    private String password;
    
    private String deviceImei;
    
    private String deviceName;
}
