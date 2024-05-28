
package com.examly.springapp.repository;

import com.examly.springapp.model.MembershipCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepo extends JpaRepository<MembershipCard, Integer> {
}
