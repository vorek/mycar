package com.myauto.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myauto.dto.AddUserRequest;
import com.myauto.entity.AppUser;
import com.myauto.entity.Device;
import com.myauto.exceptions.UserAlreadyCreatedException;
import com.myauto.ids.AppUserId;
import com.myauto.ids.DeviceId;
import com.myauto.repository.DeviceRepository;
import com.myauto.repository.UserRepository;

@Service
public class UserManagementService implements UserManagement {

    private final UserRepository userRepository;
    private final DeviceRepository deviceRepository;
    
    @Autowired
    public UserManagementService(UserRepository userRepository,
            DeviceRepository deviceRepository) {
        this.userRepository = userRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    @Transactional
    public void addUser (AddUserRequest request) throws UserAlreadyCreatedException{
        AppUser user = userRepository.findUserByEmail(request.getEmail());
        if (user != null) {
            throw new UserAlreadyCreatedException(request.getEmail());
        }
        user = AppUser.builder()
                .id(AppUserId.newId())
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        if (request.getDeviceImei() != null && !StringUtils.isEmpty(request.getDeviceImei())) {
            Device device = deviceRepository.findDeviceByImei(request.getDeviceImei());
            if (device != null) {
                device.setUserId(user.getId());
            } else {
                device = Device.builder()
                    .id(DeviceId.newId())
                    .imei(request.getDeviceImei())
                    .name(request.getDeviceName())
                    .userId(user.getId())
                    .build();
                deviceRepository.add(device);
            }
        }
        userRepository.add(user);
    }

}
