package Homework20.bService;


import Homework20.dto.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    int createStudent(Student student);
    void deleteStudent(Student student);
    List<Student> getAll();
    List<Student> getByName(String name)throws SQLException;
    List<Student> getByIds(List<Integer> ids);
}