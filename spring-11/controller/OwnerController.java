
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Owner;
import com.examly.springapp.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/asset/{assetid}")
    public ResponseEntity<Owner> mapOwnerToAsset(@PathVariable("assetid") int assetId, @RequestBody Owner owner) {
        // You can implement the mapping logic here
        // Assuming the mapping logic is implemented elsewhere
        Owner mappedOwner = ownerService.saveOwner(owner);
        return new ResponseEntity<>(mappedOwner, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable int id) {
        Owner owner = ownerService.getOwnerById(id);
        if (owner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable int id, @RequestBody Owner owner) {
        Owner existingOwner = ownerService.getOwnerById(id);
        if (existingOwner == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update fields
        existingOwner.setName(owner.getName());
        existingOwner.setEmail(owner.getEmail());
        existingOwner.setAddress(owner.getAddress());

        Owner updatedOwner = ownerService.saveOwner(existingOwner);
        return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable int id) {
        Owner owner = ownerService.getOwnerById(id);
        if (owner == null) {
            return new ResponseEntity<>("Owner not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        ownerService.deleteOwnerById(id);
        return new ResponseEntity<>("Owner deleted successfully", HttpStatus.OK);
    }
}
