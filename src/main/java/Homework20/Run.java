package Homework20;

import Homework20.bService.StudentService;
import Homework20.bService.StudentServiceImpl;
import Homework20.dto.GeneratedStudents;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<>();
        StudentService studentService = new StudentServiceImpl();
        GeneratedStudents gs = new GeneratedStudents();
        //получение
        System.out.println(studentService.getAll());
        //удаление
        studentService.deleteStudent(gs.student().get(2));
        // получение студента по айди
        ids.add(3);
        ids.add(8);
        System.out.println("---");
        System.out.println(studentService.getByIds(ids));

    }
}