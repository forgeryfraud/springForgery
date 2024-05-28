
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}