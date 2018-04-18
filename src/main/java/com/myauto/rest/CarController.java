package com.myauto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myauto.service.CarManagement;

@RestController
@RequestMapping("car")
public class CarController {
    
    @Autowired
    CarManagement carManagement;
    
    
}
