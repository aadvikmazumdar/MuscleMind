package com.example.MuscleMind.entity;

public class Member {
    private String id;
    private String name;
    private String weight;
    private String height;
    private String bloodGroup;
    private String bmi;
    private String contact;
    private String aadhar;

    // Constructors, getters, and setters

    public Member() {}

    public Member(String id, String name, String weight, String height, String bloodGroup, String bmi, String contact, String aadhar) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.bloodGroup = bloodGroup;
        this.bmi = bmi;
        this.contact = contact;
        this.aadhar = aadhar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }
}
