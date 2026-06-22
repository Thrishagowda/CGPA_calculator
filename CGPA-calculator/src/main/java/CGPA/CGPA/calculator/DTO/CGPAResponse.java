package CGPA.CGPA.calculator.DTO;

public class CGPAResponse {
    private Long studentId;
    private String studentName;
    private String cgpa;

    // ✅ Default constructor (important for Spring/Jackson)
    public CGPAResponse() {}

    // ✅ All-args constructor
    public CGPAResponse(Long studentId, String studentName, double cgpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.cgpa = String.format("%.2f", cgpa);
    }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getCgpa() { return cgpa; }
    public void setCgpa(String cgpa) { this.cgpa = cgpa; }
}
