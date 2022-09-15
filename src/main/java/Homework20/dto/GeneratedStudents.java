package Homework20.dto;

import java.util.ArrayList;
import java.util.List;

public class GeneratedStudents {

    private final List<Student> student = new ArrayList<>();

    public List<Student> student (){
        student.add(new Student(1,"Khomenchuk_E.O.",17,2017));
        student.add(new Student(2,"Okun_V.S.",21,2019));
        student.add(new Student(3,"Parhomenko_B.A.",21,2019));
        student.add(new Student(4,"Petruk_T.D.",23,2018));
        student.add(new Student(5,"Senko_I.A.",17,2017));
        student.add(new Student(6,"Mazur_A.S.",17,2017));
        return student;
    }
}
