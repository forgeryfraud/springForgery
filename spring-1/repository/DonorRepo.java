package com.examly.springapp.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.examly.springapp.model.Donor;
public interface DonorRepo extends JpaRepository<Donor,Integer> {
    Donor findByDonorId(int donorId);
    @Query("SELECT d FROM Donor d ORDER BY d.age")
    List<Donor> findByDonorId();
    @Query("SELECT d FROM Donor d ORDER BY d.bloodGroup")
    List<Donor> findByBloodGroup();
    @Query("SELECT d FROM Donor d WHERE d.age BETWEEN :minAge AND :maxAge")
    List<Donor> findByAgeRange(int minAge, int maxAge);
}