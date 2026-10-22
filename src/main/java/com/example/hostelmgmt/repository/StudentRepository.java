
package com.example.hostelmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hostelmgmt.domain.Student;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    Student findByStudentnameAndPassword(
            String studentname,
            String password);
}
