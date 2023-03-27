package com.aashi.StudentManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This entity class was created to deal with databases
 * */
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name = "course")
    private String course;
    @Column(name="phone_no")
    private Long phoneNumber;
    @Column(name="DOB")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name="address")
    private String address;


    @Column(name = "is_active")
    private boolean isActive=true;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Subject> subject= new HashSet<>();

    public Set<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Set<Subject> subject) {
        this.subject = subject;
    }

    /**
     *Whenever you create parameterized constructor ,
     *always make sure to create default constructor
     *  */
    private Student(){

    }

    public Student(int student_id, String firstName, String lastName, String email, String course, Long phoneNumber, Date dateOfBirth, String address, Set<Subject> subject) {
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.subject = subject;
    }

    public Student(int id, String firstName, String lastName, String email) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                '}';
    }
}
