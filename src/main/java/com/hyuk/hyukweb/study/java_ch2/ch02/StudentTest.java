package com.hyuk.hyukweb.study.java_ch2.ch02;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.studentNumber = 1;
        student1.studentName = "김재혁";
        student1.majorCode = 1;
        student1.majorName = "과학";
        student1.grade = 2;

        student1.showStudent();
    }
}
