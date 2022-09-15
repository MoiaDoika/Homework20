package Homework20.dbService;

import Homework20.dto.Student;
import Homework20.exception.UserNotFoundExeption;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBServiceImpl implements DBService {
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "300177");
    }

    @SneakyThrows
    @Override
    public int createStudent(Student student) {
        Connection connection = connection();
        Statement statement = connection.createStatement();
        String SQL = "insert into  student (FullName, GroupName, StartYear) value  ('%s','%s','%s')";
        return statement.executeUpdate(String.format(SQL, student.getFullName(), student.getGroupName(), student.getStartYear()));
    }

    @SneakyThrows
    @Override
    public void deleteStudent(Student student) {
        Connection connection = connection();
        Statement statement = connection.createStatement();
        String SQL = "delete from student where student_full_name ='%s'";
        statement.execute(String.format(SQL, student.getFullName()));
    }

    @SneakyThrows
    @Override
    public List<Student> getAll() {
        Connection connection = connection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from student");

        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("student_id");
            String fullName = rs.getString("student_full_name");
            int groupName = rs.getInt("student_group");
            int startYear = rs.getInt("year_of_admission");
            student.add(new Student(id, fullName, groupName, startYear));
        }
        connection.close();
        return student;
    }

    @SneakyThrows
    @Override
    public List<Student> getByName(String name) throws SQLException {
            StringBuilder sbName = new StringBuilder();
            sbName.append("'").append(name).append("'");
        Connection connection = connection();
        Statement statement = connection.createStatement();
        String SQL = "select * from student where student_full_name = '" + name + "'";
        ResultSet rs = statement.executeQuery(SQL);

        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("student_id");
            String fullName = rs.getString("student_full_name");
            int groupName = rs.getInt("student_group");
            int startYear = rs.getInt("year_of_admission");
            student.add(new Student(id, fullName, groupName, startYear));
        }
        connection.close();

        if (student.isEmpty()) {
            throw new UserNotFoundExeption(String.valueOf(name));
        } else {
            return student;
        }
    }

    @SneakyThrows
    @Override
    public List<Student> getByIds(List<Integer> ids) {
        Connection connection = connection();
        StringBuilder sbSql = new StringBuilder(1024);
        sbSql.append("SELECT * FROM student WHERE student_id IN(");

        for (int i = 0; i < ids.size(); i++) {
            if (i > 0) sbSql.append(",");
            sbSql.append(" ?");
        }
        sbSql.append(" )");
        PreparedStatement pst = connection.prepareStatement(String.valueOf(sbSql));

        for (int i = 0; i < ids.size(); i++) {
            pst.setInt(i + 1, ids.get(i));
        }
        ResultSet rs = pst.executeQuery();
        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("student_id");
            String fullName = rs.getString("student_full_name");
            int groupName = rs.getInt("student_group");
            int startYear = rs.getInt("year_of_admission");
            student.add(new Student(id, fullName, groupName, startYear));
        }
        connection.close();
        return student;
    }
}