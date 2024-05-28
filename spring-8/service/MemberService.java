
package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepo memberRepo;

    public Member addMember(Member member) {
        return memberRepo.save(member);
    }

    public Member getMemberById(int id) {
        return memberRepo.findById(id).orElse(null);
    }

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    public Member updateMember(Member member) {
        return memberRepo.save(member);
    }

    public void deleteMember(int id) {
        memberRepo.deleteById(id);
    }
}
