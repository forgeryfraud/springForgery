
package com.examly.springapp.service;

import com.examly.springapp.model.Device;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.DeviceRepository;
import com.examly.springapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private UserRepository userRepository;

    public Device createDevice(int userId, Device device) {

        User obj = userRepository.findById(userId).orElse(null);

        if(obj!=null)
        {
            device.setUser(obj);
            obj.getDevices().add(device);
            userRepository.save(obj);
            deviceRepository.save(device);
            return device;
        }
        return null;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(int id) {

        return deviceRepository.findById(id).orElse(null);
    }

    public List<Device> getDevicesByUserId(int userId) {
        // Retrieve devices by user ID
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getDevices();
        }
        return Collections.emptyList(); // Return empty list if user not found or has no devices
    }
    

    public Device updateDevice(int id, Device updatedDevice) {
        Device device = deviceRepository.findById(id).orElse(null);
        if (device != null) {
            device.setName(updatedDevice.getName());
            device.setType(updatedDevice.getType());
            device.setStatus(updatedDevice.isStatus());
            device.setSettings(updatedDevice.getSettings());
            return deviceRepository.save(device);
        }
        return null;
    }

    public boolean toggleDeviceStatus(int id) {
        Device device = deviceRepository.findById(id).orElse(null);
        if (device != null) {
            device.setStatus(!device.isStatus());
            deviceRepository.save(device);
            return true;
        }
        return false;
    }

    public Device updateDeviceSettings(int id, Device updatedDevice) {
        Device device = deviceRepository.findById(id).orElse(null);
        if (device != null) {
            device.setSettings(updatedDevice.getSettings());
            return deviceRepository.save(device);
        }
        return null;
    }

    public boolean deleteDevice(int id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
