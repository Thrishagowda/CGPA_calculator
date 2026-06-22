import axios from "axios";
import { useState } from "react";

function StudentForm() {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  // ADD THIS FUNCTION HERE
  const saveStudent = async () => {

    const student = {
      name: name,
      email: email
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/student",
        student
      );

      alert("Student Added Successfully");
      console.log(response.data);

    } catch (error) {
      console.error(error);
      alert("Error Adding Student");
    }
  };

  return (
    <div>
      <h2>Add Student</h2>

      <input
        type="text"
        placeholder="Enter Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <br /><br />

      <input
        type="email"
        placeholder="Enter Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <br /><br />

      {/* CHANGE BUTTON TO THIS */}
      <button onClick={saveStudent}>
        Add Student
      </button>
    </div>
  );
}

export default StudentForm;