import StudentForm from "./components/StudentForm";
import StudentList from "./components/StudentList";
import GradeForm from "./components/GradeForm";
function App() {
  return (
    <div>
      <h1>CGPA Calculator</h1>

      <StudentForm />

      <hr />
      <GradeForm />
      <StudentList />
    </div>
  );
}

export default App;