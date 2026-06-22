import StudentForm from "./components/StudentForm";
import StudentList from "./components/StudentList";
import GradeForm from "./components/GradeForm";
import CGPAForm from "./components/CGPAForm";
function App() {
  return (
    <div>
      <h1>CGPA Calculator</h1>

      <StudentForm />

      <hr />
       <StudentList />
      <GradeForm />
      <CGPAForm />
     
    </div>
  );
}

export default App;