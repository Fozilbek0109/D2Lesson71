package uz.coder.d2lesson71;

import java.util.List;

public interface DBService {
    void addStudent(Student student);
    void deleteStudent(Student student);
    List<Student> getAllStudent();
    int getStudentCount();
    void editStudent();
    Student getStudentById(int id);
}
