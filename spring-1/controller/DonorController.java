package com.examly.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Donor;
import com.examly.springapp.service.DonorService;
@RestController
public class DonorController {
    @Autowired
    private DonorService service;
    @PostMapping("/donor")
    public ResponseEntity<?>addDonor(@RequestBody Donor donor)
    {
        try {
            return new ResponseEntity<>(service.addDonor(donor),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @GetMapping("/donor/{donorId}")
    public ResponseEntity<?>getsDonor(@PathVariable int donorId){
        try {
            return new ResponseEntity<>(service.getsDonor(donorId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/donor")
    public ResponseEntity<?>getDonor(){
        try {
            return new ResponseEntity<>(service.getDonor(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/donor/{donorId}")
    public ResponseEntity<?>updateDonor(@PathVariable int donorId,@RequestBody Donor donor){
        try {
            return new ResponseEntity<>(service.updateDonor(donorId,donor),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   @DeleteMapping("/donor/{donorId}")
    public ResponseEntity<?> deleteDonor(@PathVariable int donorId) {
        boolean deletionStatus = service.deleteDonor(donorId);
        if (deletionStatus) {
            return new ResponseEntity<>("Donor deleted Successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Donor not found",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/donor/age/{age}")
    public ResponseEntity<?>sortByAge(){
        try {
            return new ResponseEntity<>(service.sortAge(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    @GetMapping("/donor/bloodGroup/{bloodGroup}")
    public ResponseEntity<?>sortByBloodGroup(){
        try {
            return new ResponseEntity<>(service.sortByBloodGroup(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/donor/ageRange/{minAge}/{maxAge}")
    public ResponseEntity<?>sortByAgeRange(@PathVariable int minAge,@PathVariable int maxAge){
        try {
            return new ResponseEntity<>(service.sortByAgeRange(minAge,maxAge),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
