package com.hyuk.hyukweb.study.java_ch2.ch02;

public class Student {

    // 멤버 변수
    int studentNumber;
    String studentName;
    int majorCode;
    String majorName;
    int grade;

    public void showStudent() {
        System.out.println(studentNumber + studentName + majorCode + majorName+ grade);
    }
}
