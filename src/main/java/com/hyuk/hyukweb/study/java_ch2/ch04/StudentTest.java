package com.hyuk.hyukweb.study.java_ch2.ch04;

public class StudentTest {

    public static void main(String[] args) {

        Student studentKim = new Student();
        studentKim.studentID = 12345;
        studentKim.setStudentName("김재혁");
        studentKim.address = "대구";
        studentKim.showStudentInfo();

        Student studentLee = new Student();
        studentLee.studentID = 123;
        studentLee.studentName = "Lee";
        studentLee.address = "부산";
        studentLee.showStudentInfo();
        System.out.println(studentKim);
        System.out.println(studentLee);

    }
}
