package com.student.controller;
import com.student.entity.Student;
import com.student.entity.Marks;
import com.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) { this.service = service; }

    @GetMapping("/")
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/student/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        model.addAttribute("newMark", new Marks());
        return "view_student";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }

    @PostMapping("/student/{id}/marks")
    public String addMark(@PathVariable Long id, @ModelAttribute("newMark") Marks mark) {
        service.addMark(id, mark);
        return "redirect:/student/" + id;
    }
}
