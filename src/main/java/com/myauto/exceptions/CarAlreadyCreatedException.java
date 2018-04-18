package com.myauto.exceptions;

public class CarAlreadyCreatedException extends Exception {
    private final static String MESSAGE_TEMPLATE = "���������� � ���-����� [%s] ��� ���������� � ����";
    
    private final String vincode;
    
    public CarAlreadyCreatedException(String vincode) {
        super(String.format(MESSAGE_TEMPLATE, vincode));
        this.vincode = vincode;
    }
    
    public String getVinCode() {
        return this.vincode;
    }
}
