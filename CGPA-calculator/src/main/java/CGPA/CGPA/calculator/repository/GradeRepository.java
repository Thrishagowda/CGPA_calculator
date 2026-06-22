package CGPA.CGPA.calculator.repository;
import CGPA.CGPA.calculator.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId); // fetch grades of a student
}
