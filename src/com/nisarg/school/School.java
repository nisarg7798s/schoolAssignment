package com.nisarg.school;

public interface School {
    Student admitStudent(String name, int age, String grade);
    Double chargeFees(Student student);
}
