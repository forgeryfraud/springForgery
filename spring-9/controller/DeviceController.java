
package com.examly.springapp.controller;

import com.examly.springapp.model.Device;
import com.examly.springapp.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/devices/user/{userId}")
    public ResponseEntity<Device> createDevice(@PathVariable int userId, @RequestBody Device device) {
        Device newDevice = deviceService.createDevice(userId, device);
        return new ResponseEntity<>(newDevice, HttpStatus.CREATED);
    }

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable int id) {
        Device device = deviceService.getDeviceById(id);
        if (device == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @GetMapping("/devices/user/{userId}")
    public ResponseEntity<List<Device>> getDevicesByUserId(@PathVariable int userId) {
        List<Device> devices = deviceService.getDevicesByUserId(userId);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @PutMapping("/devices/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable int id, @RequestBody Device updatedDevice) {
        Device device = deviceService.updateDevice(id, updatedDevice);
        if (device == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PutMapping("/devices/{id}/toggle")
    public ResponseEntity<String> toggleDeviceStatus(@PathVariable int id) {
        boolean toggled = deviceService.toggleDeviceStatus(id);
        if (toggled) {
            return new ResponseEntity<>("Device status toggled successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/devices/{id}/settings")
    public ResponseEntity<Device> updateDeviceSettings(@PathVariable int id, @RequestBody Device updatedDevice) {
        Device device = deviceService.updateDeviceSettings(id, updatedDevice);
        if (device == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @DeleteMapping("/devices/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable int id) {
        
            return new ResponseEntity<>("Device deleted successfully", HttpStatus.OK);
       
    }
}
