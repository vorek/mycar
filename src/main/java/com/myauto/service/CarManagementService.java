package com.myauto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myauto.dto.AddCarRequest;
import com.myauto.entity.AppUser;
import com.myauto.entity.Car;
import com.myauto.exceptions.CarAlreadyCreatedException;
import com.myauto.exceptions.UserNotFoundException;
import com.myauto.ids.CarId;
import com.myauto.repository.CarRepository;
import com.myauto.repository.UserRepository;

@Service
public class CarManagementService implements CarManagement {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarManagementService(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(AddCarRequest request) throws UserNotFoundException, CarAlreadyCreatedException {
        AppUser user = userRepository.get(request.getUserId());
        Car car = carRepository.findCarByVinCode(request.getVinCode());
        if (car != null) {
            throw new CarAlreadyCreatedException(car.getVinCode());
        }
        car = Car.builder()
                .id(CarId.newId())
                .vendor(request.getVendor())
                .model(request.getModel())
                .year(request.getYear())
                .mileage(request.getMileage())
                .fuelType(request.getFuelType())
                .vinCode(request.getVinCode())
                .userId(user.getId())
                .build();
        carRepository.add(car);
    }

}
