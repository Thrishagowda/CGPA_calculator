package CGPA.CGPA.calculator.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "grade")
public class Grade {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private double marks;
    private double credits;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    // Constructors
    public Grade() {}

    public Grade(String subject, double marks, double credits, Student student) {
        this.subject = subject;
        this.marks = marks;
        this.credits = credits;
        this.student = student;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    public double getCredits() { return credits; }
    public void setCredits(double credits) { this.credits = credits; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}