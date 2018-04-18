package com.myauto.service;

import com.myauto.dto.AddCarRequest;
import com.myauto.exceptions.CarAlreadyCreatedException;
import com.myauto.exceptions.UserNotFoundException;

public interface CarManagement {
    void addCar(AddCarRequest request) throws UserNotFoundException, CarAlreadyCreatedException;
}
