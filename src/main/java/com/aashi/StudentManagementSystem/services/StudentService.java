package com.aashi.StudentManagementSystem.services;

import com.aashi.StudentManagementSystem.entities.Student;
import com.aashi.StudentManagementSystem.exceptionHandlers.ResourceNotFoundException;

import java.util.List;

public interface StudentService {
    /**
     * GET DETAILS OF ALL THE STUDENTS
     * */
    public List<Student> getAllStudents();

    /**
     * SAVE DETAILS OF ALL THE STUDENTS CREATED
     * */
    public Student saveStudent(Student student);

    /**
     * UPDATE THE DETAILS OF STUDENTS
     * */
    public Student updateStudentDetails( int id, Student student) throws ResourceNotFoundException;

    /**
     * GET DETAILS OF ALL THE STUDENTS BASED ON ID
     * */
    Student getStudentById(int id);

    /**
     * DELETE A STUDENT BASED ON ID
     * */
    boolean deleteStudent(int id);

    /**
     * Get student based on subject id
     * */
    public List<Student> getStudentBySubjectId(Integer subjectId);



}
