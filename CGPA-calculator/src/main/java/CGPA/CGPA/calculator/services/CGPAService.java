package CGPA.CGPA.calculator.services;

import CGPA.CGPA.calculator.model.Grade;
import CGPA.CGPA.calculator.repository.GradeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CGPAService {

    private final GradeRepository gradeRepository;

    public CGPAService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public double calculateCGPA(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);

        if (grades.isEmpty()) return 0.0;

        double totalPoints = 0.0;
        double totalCredits = 0.0;

        for (Grade g : grades) {
            totalPoints += g.getMarks() * g.getCredits(); // directly use marks
            totalCredits += g.getCredits();
        }

        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }
}
