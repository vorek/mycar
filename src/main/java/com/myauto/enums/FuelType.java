package com.myauto.enums;

public enum FuelType {

    /**
     * Бензин
     */
    GASOLINE("Бензин"),
    
    /**
     * Дизель
     */
    DIESEL("Дизель"),
    
    /**
     * Газ + Бензин
     */
    GASANDGASOLINE("Газ + Бензин"),
    
    /**
     * Гибрид
     */
    HYBRID("Гибрид"),
    
    /**
     * Электро
     */
    ELECTRO("Электро"),
    
    /**
     * Другое
     */
    OTHER("Другое");
    
    private String code;

    FuelType(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
