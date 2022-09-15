package Homework20.bService;


import Homework20.dbService.DBService;
import Homework20.dbService.DBServiceImpl;
import Homework20.dto.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final DBService dbService = new DBServiceImpl();

    @Override
    public int createStudent(Student student) {
        return dbService.createStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        dbService.deleteStudent(student);
    }

    @Override
    public List<Student> getAll() {
        return dbService.getAll();
    }

    @Override
    public List<Student> getByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<Student> getByIds(List<Integer> ids) {
        return dbService.getByIds(ids);
    }
}
