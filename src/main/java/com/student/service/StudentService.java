package com.student.service;
import com.student.entity.Student;
import com.student.entity.Marks;
import com.student.repository.StudentRepository;
import com.student.repository.MarksRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepo;
    private final MarksRepository marksRepo;

    public StudentService(StudentRepository studentRepo, MarksRepository marksRepo) {
        this.studentRepo = studentRepo;
        this.marksRepo = marksRepo;
    }

    public List<Student> getAllStudents() { return studentRepo.findAll(); }
    public Student getStudentById(Long id) { return studentRepo.findById(id).orElse(null); }
    public void saveStudent(Student student) { studentRepo.save(student); }
    public void deleteStudent(Long id) { studentRepo.deleteById(id); }
    
    public void addMark(Long studentId, Marks mark) {
        Student student = getStudentById(studentId);
        if(student != null) {
            mark.setStudent(student);
            marksRepo.save(mark);
        }
    }
}
