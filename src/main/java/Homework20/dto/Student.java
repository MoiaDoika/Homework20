package Homework20.dto;

import lombok.Data;

@Data
public class Student {
    private int student_id;
    private String student_full_name;
    private int student_group;
    private int year_of_admission;

    public Student(String fullName, int groupName, int startYear) {
        this.student_full_name = student_full_name;
        this.student_group = student_group;
        this.year_of_admission = year_of_admission;
    }

    public Student() {
    }

    public Student(int student_id, String student_full_name, int groupName, int startYear) {
        this.student_id = student_id;
        this.student_full_name = student_full_name;
        this.student_group = student_group;
        this.year_of_admission = year_of_admission;
    }

    public String getFullName() {
        return student_full_name;
    }

    public void setFullName(String student_full_name) {
        this.student_full_name = student_full_name;
    }

    public int getGroupName() {
        return student_group;
    }

    public void setGroupName(int groupName) {
        this.student_group = groupName;
    }

    public int getStartYear() {
        return year_of_admission;
    }

    public void setStartYear(int startYear) {
        this.year_of_admission = startYear;
    }
}