package com.aashi.StudentManagementSystem.repository;

import com.aashi.StudentManagementSystem.dto.StudentDto;
import com.aashi.StudentManagementSystem.entities.Student;
import com.aashi.StudentManagementSystem.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JpaRepository<T, ID>
 * T = Type of JPA Entity
 * ID = Data Type of primary key
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value= "select s1_0.student_id, s1_0.address, s1_0.course, s1_0.dob, s1_0.email, s1_0.first_name, s1_0.is_active, s1_0.last_name, s1_0.phone_no from students s1_0 left join subject s2_0 on s1_0.student_id=s2_0.student_id where s1_0.is_Active=1 AND s2_0.id =:subjectId", nativeQuery=true)
    List<Student> findAllBySubject(Integer subjectId);

    @Query(value = "SELECT * FROM students WHERE is_active=1", nativeQuery = true)
    List<Student> getAllStudent();

    @Query(value = "SELECT * FROM students WHERE is_active='1' AND student_id=:studentId",nativeQuery = true)
    Student getStudentById(@Param("studentId") int studentId);

}
