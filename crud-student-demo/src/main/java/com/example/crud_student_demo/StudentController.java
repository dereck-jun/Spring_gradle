package com.example.crud_student_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String listAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("studentinfo", students);
        return "students/list";
    }

    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("studentinfo", new Student());
        return "students/create";
    }

    @PostMapping("/create")
    public String handleCreateStudentForm(@ModelAttribute Student studentRequest) {
        Student student = studentService.create(studentRequest);

        if (student == null) {
            return "students/createFail";
        }
        return "redirect:/students";
    }

    @GetMapping("/createFail")
    public String createFail() {
        return "students/createFail";
    }

    @GetMapping("/detail_list/{id}")
    public String updateStudentForm(@PathVariable Integer id, Model model) {
        Student studentResponse = studentService.read(id);

        Student studentRequest = Student.builder()
                .studentId(studentResponse.getStudentId())
                .name(studentResponse.getName())
                .email(studentResponse.getEmail())
                .phoneNumber(studentResponse.getPhoneNumber())
                .build();

        model.addAttribute("studentinfo", studentRequest);
        return "students/detail_list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);

        return "students";
    }
}
