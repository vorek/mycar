package com.myauto.exceptions;

public class UserAlreadyCreatedException extends Exception {
    private final static String MESSAGE_TEMPLATE = "ѕользователь с e-mail [%s] уже существует в базе";
    
    private final String email;
    
    public UserAlreadyCreatedException(String email) {
        super(String.format(MESSAGE_TEMPLATE, email));
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
}
