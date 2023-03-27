package com.aashi.StudentManagementSystem.services.Implementations;

import com.aashi.StudentManagementSystem.entities.Student;
import com.aashi.StudentManagementSystem.entities.Subject;
import com.aashi.StudentManagementSystem.exceptionHandlers.ResourceNotFoundException;
import com.aashi.StudentManagementSystem.repository.StudentRepository;
import com.aashi.StudentManagementSystem.repository.SubjectRepository;
import com.aashi.StudentManagementSystem.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Subject> getAllSubjectsByStudent(Integer studentId) {

        Student student = studentRepository.getStudentById(studentId);
        if (student == null){
            throw new ResourceNotFoundException("student", studentId);
        }
        if(student.isActive() == false){
            throw new ResourceNotFoundException("Student" ,  studentId);
        }
          return subjectRepository.findAllByStudent(student);
    }

    @Override
    public Subject createSubject(Subject subject,Integer studentId) {
        Student student = studentRepository.getStudentById(studentId);
        if(student==null)
        {
            throw new ResourceNotFoundException("Student",studentId);
        }
        subject.setStudent(student);
        return subjectRepository.save(subject);
    }
}
