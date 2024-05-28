
package com.examly.springapp.service;

import com.examly.springapp.model.MembershipCard;
import com.examly.springapp.repository.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepo membershipRepo;

    public MembershipCard addMembership(MembershipCard membershipCard) {
        return membershipRepo.save(membershipCard);
    }

    public MembershipCard getMembershipById(int id) {
        Optional<MembershipCard> optionalMembershipCard = membershipRepo.findById(id);
        return optionalMembershipCard.orElse(null);
    }

    public MembershipCard updateMembership(MembershipCard membershipCard) {
        return membershipRepo.save(membershipCard);
    }

    public void deleteMembership(int id) {
        membershipRepo.deleteById(id);
    }
}
