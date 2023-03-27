package com.aashi.StudentManagementSystem.controllers;

import com.aashi.StudentManagementSystem.dto.StudentDto;
import com.aashi.StudentManagementSystem.entities.Student;
import com.aashi.StudentManagementSystem.services.StudentService;
import com.aashi.StudentManagementSystem.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;


    /**
     * @Autowired in modelMapper will not work because NO bean of model mapper is found
     * what can be done then?
     * -> before Autowired -> (Define the model mapper bean)
     * <p>
     * How to create the bean of class , which I have not created
     * <p>
     * ->If we make a class and uska agar bean banana hai to we use @Component
     * //but I asked for maven for model mapper, we didn't made any class of model mapper thefore
     * cant use @Component Annotation
     * //WE USE @Bean annotation in this case
     */
    @Autowired
    private ModelMapper modelMapper;


    //Get list all students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(convertStudentToStudentDto(student));
        }

        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }


     // Get student based on studentId
    @GetMapping("/{studentId}")
    public ResponseEntity getStudentById(@PathVariable(value = "studentId") int id) {

        Student student = studentService.getStudentById(id);

        /**
         * I first have to -> convert the Student Object to StudentDto object
         * */
        StudentDto studentDto = convertStudentToStudentDto(student);

        return new ResponseEntity(studentDto, HttpStatus.OK);
    }


     //Get student based on SubjectId
    @GetMapping("/subjects/{subjectId}")
    public ResponseEntity getStudentBySubjectId(@PathVariable(value = "subjectId") int id) {
        List<Student> student = studentService.getStudentBySubjectId(id);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student s : student) {
            studentDtos.add(convertStudentToStudentDto(s));
        }
        return new ResponseEntity(studentDtos, HttpStatus.OK);
    }


    //Converting function/method
    private StudentDto convertStudentToStudentDto(Student student) {
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }


    //Create student
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStudent(@RequestBody StudentDto studentDto) {

        Student student = modelMapper.map(studentDto, Student.class);
        Student savedStudent = studentService.saveStudent(student);
        StudentDto responseBody = modelMapper.map(savedStudent, StudentDto.class);
        return new ResponseEntity(responseBody, HttpStatus.CREATED);
    }


     //Update student based on studentId
    @PutMapping(value = "/{studentId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudentDetails
    (@RequestBody StudentDto studentDto, @PathVariable(name = "studentId") int id) throws Exception {

        Student student = modelMapper.map(studentDto, Student.class);

        Student retrievedStudent = studentService.updateStudentDetails(id, student);

        StudentDto studentToBeUpdated = modelMapper.map(retrievedStudent, StudentDto.class);
        return new ResponseEntity(studentToBeUpdated, HttpStatus.ACCEPTED);
    }


     //Delete student based in studentId
    @DeleteMapping(value = "/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable(name = "studentId") int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity("Student is deleted", HttpStatus.OK);
    }


}
