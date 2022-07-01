package com.manuel.decadev;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Course Modelling with java...");
    Course course1 = new Course("Java Programming");
    Course course2 = new Course("Javascript Course");

    course1.addStudent("Student One");
    course1.addStudent("Student Two");
    course1.addStudent("Agboola Stephen");
    System.out.println(course1.getNumberOfStudentTaking());

    course2.addStudent("Student Three");
    course2.addStudent("Student One");

        System.out.printf("Number of student taking course 1: %d and course 2 is: %d\n",
                course1.getNumberOfStudentTaking(), course2.getNumberOfStudentTaking() );

        // loop to get each course name out
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudentTaking(); i += 1){
            System.out.print(students[i]);
            if (students[i+1] != null)
                System.out.println(",");
        }
    }
}
