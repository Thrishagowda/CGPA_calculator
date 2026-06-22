import { useState } from "react";
import axios from "axios";

function GradeForm() {

  const [studentId, setStudentId] = useState("");
  const [subject, setSubject] = useState("");
  const [marks, setMarks] = useState("");
  const [credits, setCredits] = useState("");

  const saveGrade = async () => {

    const grade = {
      subject,
      marks,
      credits
    };

    try {

      await axios.post(
        `http://localhost:8080/grade/${studentId}`,
        grade
      );

      alert("Grade Added Successfully");

    } catch (error) {

      console.error(error);
      alert("Error Adding Grade");
    }
  };

  return (
    <div>
      <h2>Add Grade</h2>

      <input
        type="number"
        placeholder="Student ID"
        value={studentId}
        onChange={(e) => setStudentId(e.target.value)}
      />

      <br /><br />

      <input
        type="text"
        placeholder="Subject"
        value={subject}
        onChange={(e) => setSubject(e.target.value)}
      />

      <br /><br />

      <input
        type="number"
        placeholder="Marks"
        value={marks}
        onChange={(e) => setMarks(e.target.value)}
      />

      <br /><br />

      <input
        type="number"
        placeholder="Credits"
        value={credits}
        onChange={(e) => setCredits(e.target.value)}
      />

      <br /><br />

      <button onClick={saveGrade}>
        Add Grade
      </button>
    </div>
  );
}

export default GradeForm;