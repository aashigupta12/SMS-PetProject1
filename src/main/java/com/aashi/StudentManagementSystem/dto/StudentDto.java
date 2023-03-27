package com.aashi.StudentManagementSystem.dto;

import com.aashi.StudentManagementSystem.entities.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

/**
 * This class will be used to convert client JSON request
 * to Java Object & vice-versa
 * */
/**
 * @JsonProperty is used to customize the field names
 * */
public class StudentDto {
    private int student_id;
    private String firstName;
    private String lastName;
    private String email;
    private String course;
    @JsonProperty("phone_No")
    private Long phoneNumber;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String address;

    private boolean isActive=true;



    /**
     * I only want subjectId to be pass as a request,
     * therefore I copied only subjectId and put it there
     * */
    private int subjectId;
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "student_id=" + student_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }
}
