package com.example.MuscleMind.controller;

import com.example.MuscleMind.entity.Member;
import com.example.MuscleMind.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Get a single member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable String id) {
        Optional<Member> memberOpt = memberService.getMemberById(id);
        return memberOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new member
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member createdMember = memberService.saveMember(member);
        return ResponseEntity.ok(createdMember);
    }

    // Update an existing member
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable String id, @RequestBody Member memberDetails) {
        Optional<Member> existingMemberOpt = memberService.getMemberById(id);
        if (existingMemberOpt.isPresent()) {
            Member existingMember = existingMemberOpt.get();
            existingMember.setName(memberDetails.getName());
            existingMember.setWeight(memberDetails.getWeight());
            existingMember.setHeight(memberDetails.getHeight());
            existingMember.setBloodGroup(memberDetails.getBloodGroup());
            existingMember.setBmi(memberDetails.getBmi());
            existingMember.setContact(memberDetails.getContact());
            existingMember.setAadhar(memberDetails.getAadhar());
            memberService.saveMember(existingMember);
            return ResponseEntity.ok(existingMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a member by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable String id) {
        boolean deleted = memberService.deleteMemberById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
