package com.aashi.StudentManagementSystem.services;

import com.aashi.StudentManagementSystem.entities.Subject;

import java.util.List;

public interface SubjectService {

    /**
     * Get all the subjects for a given student Id
     * */
    public List<Subject> getAllSubjectsByStudent(Integer subjectId);

    /**
     * Create a new subject
     * */
    public Subject createSubject(Subject subject,Integer studentId);
}
