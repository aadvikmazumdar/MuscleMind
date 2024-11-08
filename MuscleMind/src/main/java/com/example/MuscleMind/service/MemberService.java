package com.example.MuscleMind.service;

import com.example.MuscleMind.entity.Member;
import com.example.MuscleMind.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member); // Assuming the member object has the ID set already
    }

    public boolean deleteMemberById(String id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true; // Indicate successful deletion
        }
        return false; // Indicate that the member was not found
    }
}
