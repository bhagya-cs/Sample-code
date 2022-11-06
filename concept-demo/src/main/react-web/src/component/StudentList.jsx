import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function StudentList() {
  const [students, setStudents] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const response = await axios.get("/api/students/");
      setStudents(response.data);
    };
    fetchData();
  }, []);

  return (
    <section className="section">
      <table className="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.name}</td>
              <td>{student.email}</td>
              <td>
                <Link to={`/students/edit/${student.id}`}>
                  <i className="fas fa-user-edit ml-2"></i>
                </Link>
              </td>
              <td>
                <Link to={`/students/delete/${student.id}`}>
                  <i className="fas fa-user-times ml-2"></i>
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <p className="my-5">
        <a href="add" className="btn btn-primary">
          <i className="fas fa-user-plus ml-2"></i>
        </a>
      </p>
    </section>
  );
}

export default StudentList;
