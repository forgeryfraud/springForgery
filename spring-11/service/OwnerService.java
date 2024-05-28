
package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Owner;
import com.examly.springapp.repository.OwnerRepository;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner getOwnerById(int id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public void deleteOwnerById(int id) {
        ownerRepository.deleteById(id);
    }
}