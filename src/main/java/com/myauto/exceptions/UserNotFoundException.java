package com.myauto.exceptions;

public class UserNotFoundException extends Exception {
    private final static String MESSAGE_TEMPLATE = "������������ � ID [%s] �� ���������� � ����";
    
    private final String id;
    
    public UserNotFoundException(String id) {
        super(String.format(MESSAGE_TEMPLATE, id));
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
}
