package com.examly.springapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Donor;
import com.examly.springapp.repository.DonorRepo;
@Service
public class DonorService {
    @Autowired
    private DonorRepo repo;
    public Donor addDonor(Donor donor) {
        return repo.save(donor);
    }
    public Donor getsDonor(int donorId) {
        return repo.findByDonorId(donorId);
    }
    public List<Donor> getDonor() {
        return repo.findAll();
    }
    public Donor updateDonor(int donorId,Donor donor) {
        Optional <Donor> donorExist = repo.findById(donorId);
        if(donorExist.isPresent()){
            Donor existingDonor =  donorExist.get();
            existingDonor.setName(donor.getName());
            existingDonor.setAge(donor.getAge());
            existingDonor.setAddress(donor.getAddress());
            return repo.save(donor);
        }
        return new Donor();
    }
    public boolean deleteDonor(int donorId) {
        Optional<Donor> donorExist = repo.findById(donorId);
        if (donorExist.isPresent()) {
            repo.deleteById(donorId);
            System.out.println("Donor deleted Successfully");
            return true;
        } else {
            System.out.println("Donor not found");
            return false;
        }
    }
    public List<Donor> sortAge() {
        return repo.findByDonorId();
    }
    public List<Donor> sortByBloodGroup() {
        return repo.findByBloodGroup();
    }
   public List<Donor> sortByAgeRange(int minAge, int maxAge) {
        return repo.findByAgeRange(minAge,maxAge);
    }
}