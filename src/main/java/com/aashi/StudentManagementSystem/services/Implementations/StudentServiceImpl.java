package com.aashi.StudentManagementSystem.services.Implementations;

import com.aashi.StudentManagementSystem.entities.Student;
import com.aashi.StudentManagementSystem.entities.Subject;
import com.aashi.StudentManagementSystem.exceptionHandlers.ResourceNotFoundException;
import com.aashi.StudentManagementSystem.repository.StudentRepository;
import com.aashi.StudentManagementSystem.repository.SubjectRepository;
import com.aashi.StudentManagementSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;


    /**
     * how to do isActive false in get all students?
     * */
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    @Override
    public Student getStudentById(int id) throws ResourceNotFoundException{
        Student student = studentRepository.getStudentById(id);
        if(student == null)
        { throw new ResourceNotFoundException("Student", id);
        }
        if(student.isActive()==false)
        {
            throw new ResourceNotFoundException("Student", id);
        }
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentDetails( int id, Student student){
        Student registerdStudent = studentRepository.getStudentById(id);

        if(registerdStudent==null)
        {
            throw new ResourceNotFoundException("Student", id);
        }

        registerdStudent.setFirstName(student.getFirstName());
        registerdStudent.setLastName(student.getLastName());
        registerdStudent.setEmail(student.getEmail());
        registerdStudent.setAddress(student.getAddress());
        registerdStudent.setCourse(student.getCourse());
        registerdStudent.setPhoneNumber(student.getPhoneNumber());
        registerdStudent.setDateOfBirth(student.getDateOfBirth());
        registerdStudent.setActive(student.isActive());

        return studentRepository.save(registerdStudent);
    }

    @Override
    public boolean deleteStudent(int id) throws ResourceNotFoundException{
        Student studentToBeDeleted = getStudentById(id);

        studentToBeDeleted.setActive(false);

        Student savedStudent = updateStudentDetails(studentToBeDeleted.getStudent_id(),studentToBeDeleted);
        return true;
    }

    /**
     * fetch Student by subject ID
     * */
    @Override
    public  List<Student> getStudentBySubjectId(Integer subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("subject",  subjectId));

        return studentRepository.findAllBySubject(subject.getSubjectId());
    }
}
