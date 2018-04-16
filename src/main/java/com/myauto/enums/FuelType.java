package com.myauto.enums;

public enum FuelType {

    /**
     * ������
     */
    GASOLINE("������"),
    
    /**
     * ������
     */
    DIESEL("������"),
    
    /**
     * ��� + ������
     */
    GASANDGASOLINE("��� + ������"),
    
    /**
     * ������
     */
    HYBRID("������"),
    
    /**
     * �������
     */
    ELECTRO("�������"),
    
    /**
     * ������
     */
    OTHER("������");
    
    private String code;

    FuelType(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
