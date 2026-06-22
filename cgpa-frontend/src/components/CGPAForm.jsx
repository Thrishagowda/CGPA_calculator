import { useState } from "react";
import axios from "axios";

function CGPAForm() {

  const [studentId, setStudentId] = useState("");
  const [cgpaData, setCgpaData] = useState(null);

  const getCGPA = async () => {
    try {

      const response = await axios.get(
        `http://localhost:8080/grade/${studentId}/cgpa`
      );

      setCgpaData(response.data);

    } catch (error) {
      console.error(error);
      alert("Unable to fetch CGPA");
    }
  };

  return (
    <div>
      <h2>Calculate CGPA</h2>

      <input
        type="number"
        placeholder="Student ID"
        value={studentId}
        onChange={(e) => setStudentId(e.target.value)}
      />

      <br /><br />

      <button onClick={getCGPA}>
        Calculate CGPA
      </button>

      <br /><br />

      {cgpaData && (
        <div>
          <h3>Result</h3>

          <p>
            <b>Student Name:</b> {cgpaData.studentName}
          </p>

          <p>
            <b>CGPA:</b> {cgpaData.cgpa}
          </p>
        </div>
      )}
    </div>
  );
}

export default CGPAForm;