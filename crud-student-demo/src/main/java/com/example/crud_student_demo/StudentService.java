package com.example.crud_student_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student) {
        Student savedStudent = studentRepository.save(student);
        return toStudentResponse(savedStudent);
    }

    public Student read(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return toStudentResponse(student);
        }

        return null;
    }

    private Student toStudentResponse(Student student) {
        return Student.builder()
                .studentId(student.getStudentId())
                .name(student.getName())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .build();
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::toStudentResponse).collect(Collectors.toList());
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
