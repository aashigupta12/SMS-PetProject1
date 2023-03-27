package com.aashi.StudentManagementSystem.controllers;

import com.aashi.StudentManagementSystem.dto.SubjectDto;
import com.aashi.StudentManagementSystem.entities.Subject;
import com.aashi.StudentManagementSystem.services.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all subjects by studentId
     * */
    @GetMapping("/{subjectId}")
    public ResponseEntity<List<Subject>> getAllSubjectsByStudent(@PathVariable Integer subjectId) {
        List<Subject> subjects = subjectService.getAllSubjectsByStudent(subjectId);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    /**
     * Create Subject by StudentId
     * */
    @PostMapping("/{studentId}")
    public ResponseEntity createSubject(@RequestBody SubjectDto subjectDto, @PathVariable Integer studentId) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        Subject saveSubject = subjectService.createSubject(subject,studentId);
        SubjectDto responseBody = modelMapper.map(saveSubject, SubjectDto.class);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }
}
