package CGPA.CGPA.calculator.controller;

import CGPA.CGPA.calculator.DTO.CGPAResponse;
import CGPA.CGPA.calculator.model.Grade;
import CGPA.CGPA.calculator.model.Student;
import CGPA.CGPA.calculator.repository.GradeRepository;
import CGPA.CGPA.calculator.repository.StudentRepository;
import CGPA.CGPA.calculator.services.CGPAService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "http://localhost:5173")
public class GradeController {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final CGPAService cgpaService;

    public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository, CGPAService cgpaService) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.cgpaService = cgpaService;
    }

    @PostMapping("/{studentId}")
    public Grade addGrade(@PathVariable Long studentId, @RequestBody Grade grade) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        grade.setStudent(student);
        return gradeRepository.save(grade);
    }

    @GetMapping("/{studentId}")
    public List<Grade> getGradesByStudent(@PathVariable Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @GetMapping("/{studentId}/cgpa")
    public CGPAResponse calculateCGPA(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        double cgpa = cgpaService.calculateCGPA(studentId);
        return new CGPAResponse(student.getId(), student.getName(), cgpa);
    }
}
