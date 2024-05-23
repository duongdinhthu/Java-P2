package libraryManagement.model;

import libraryManagement.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {
    public void createStudent(Student student) throws SQLException;
    public ArrayList<Student> getAllStudent() throws SQLException;
    public Student getStudentById(int student) throws SQLException;
    public void updateStudent(Student student) throws SQLException;
    public boolean deleteStudent(int studentId) throws SQLException;
}
