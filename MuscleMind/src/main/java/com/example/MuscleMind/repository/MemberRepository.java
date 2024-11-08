package com.example.MuscleMind.repository;

import com.example.MuscleMind.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Member> findAll() {
        String sql = "SELECT * FROM members"; // Adjust the table name as needed
        return jdbcTemplate.query(sql, this::mapRowToMember);
    }


    public int save(Member member) {
        String sql = "INSERT INTO members (id, name, weight, height, blood_group, bmi, contact, aadhar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, member.getId(), member.getName(), member.getWeight(), member.getHeight(),
                member.getBloodGroup(), member.getBmi(), member.getContact(), member.getAadhar());
    }

    public int update(Member member) {
        String sql = "UPDATE members SET name = ?, weight = ?, height = ?, blood_group = ?, bmi = ?, contact = ?, aadhar = ? WHERE id = ?";
        return jdbcTemplate.update(sql, member.getName(), member.getWeight(), member.getHeight(),
                member.getBloodGroup(), member.getBmi(), member.getContact(), member.getAadhar(), member.getId());
    }

    public int deleteById(String id) {
        String sql = "DELETE FROM members WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private Member mapRowToMember(ResultSet rs, int rowNum) throws SQLException {
        return new Member(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("weight"),
                rs.getString("height"),
                rs.getString("blood_group"),
                rs.getString("bmi"),
                rs.getString("contact"),
                rs.getString("aadhar")
        );
    }


    public Member findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    public boolean existsById(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
}
