package com.manuel.decadev;

    public class Course {

    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudentTaking = 0;


    public Course (String courseName) {
    this.courseName = courseName;
    }

    public void addStudent (String student){
        students[numberOfStudentTaking] = student;
        numberOfStudentTaking += 1;

    }

    public void dropStudent(String student){
        // implement later

    }

    public String getCourseName() {
        return courseName;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudentTaking() {
        return numberOfStudentTaking;
    }

}
