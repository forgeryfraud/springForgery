
package com.examly.springapp.controller;

import com.examly.springapp.model.MembershipCard;
import com.examly.springapp.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership-cards")
public class MembershipCardController {
    @Autowired
    private MembershipService membershipService;

    @PostMapping("/member/{id}")
    public ResponseEntity<MembershipCard> addMembership(@PathVariable("id") int memberId, @RequestBody MembershipCard membershipCard) {
        MembershipCard newMembership = membershipService.addMembership(membershipCard);
        return new ResponseEntity<>(newMembership, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipCard> getMembershipById(@PathVariable("id") int id) {
        MembershipCard membershipCard = membershipService.getMembershipById(id);
        return new ResponseEntity<>(membershipCard, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipCard> updateMembership(@PathVariable("id") int id, @RequestBody MembershipCard membershipCard) {
        if (membershipCard.getId() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MembershipCard updatedMembership = membershipService.updateMembership(membershipCard);
        return new ResponseEntity<>(updatedMembership, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMembership(@PathVariable("id") int id) {
        membershipService.deleteMembership(id);
        return new ResponseEntity<>("Membership Card Deleted Successfully", HttpStatus.OK);
    }
}
