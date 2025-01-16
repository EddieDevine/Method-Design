/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.methoddesign;

//imports
import java.util.Scanner;
import java.util.ArrayList;


// @author edevine2025

public class MethodDesign {

    public static void main(String[] args) {
        System.out.println("Hello World!\n");
        
        Scanner scanner = new Scanner(System.in); // create scanner for input
        
        ArrayList<Student> studentList = new ArrayList<>(); // create a list of students
        
        boolean complete = false; // boolean to end loop
        while(!complete){
            Double[] scores = {0.0, 0.0, 0.0}; //scores for student
            String first, last; // student name
            
            System.out.println("Add Student");
            
            System.out.print("First Name: "); // input student first name
            first = scanner.nextLine();
            
            System.out.print("Last Name: "); // input student last name
            last = scanner.nextLine();
            
            //input student scores
            System.out.print("Score 1: ");
            scores[0] = Double.parseDouble(scanner.nextLine());
            System.out.print("Score 2: ");
            scores[1] = Double.parseDouble(scanner.nextLine());
            System.out.print("Score 3: ");
            scores[2] = Double.parseDouble(scanner.nextLine());
            
            Student newStudent = new Student(first, last, scores); // create student
            studentList.add(newStudent); // add student to list
            
            System.out.print("Add another student? (yes/no): "); // option to add more students: break loop?
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                complete = true;
            }
        }
        
        //print students
        System.out.println("\nStudent List:");
        for(Student student : studentList) {
            System.out.println(student.toString());
        }
    }

}

class Course {
    private Double testScore; // score for the class
    
    public Course(){ //default constructor 
        testScore = 0.0;
    }
    
    public Course(Double inScore){ // set test score in constructor 
        testScore = inScore;
    }
    
    public Double getTestScore(){ // getter for test score
        return testScore;
    }
    
    public void setTestScore(Double inScore){ // setter for test score
        testScore = inScore;
    }
}

class Student {
    private String firstName, lastName; // student name
    private Course[] courses; // courses that student has (3)
    
    public Student(){ // default constructor
        firstName = "N/A";
        lastName = "N/A";
        courses = new Course[]{new Course(), new Course(), new Course()};
    }
    
    public Student(String first, String last, Double[] inScores){ // constructor: sets name and scores
        firstName = first;
        lastName = last;
        courses = new Course[]{new Course(inScores[0]), new Course(inScores[1]), new Course(inScores[2])};
    }
    
    @Override
    public String toString(){ //print out student information
        String result;
        result = "Student: " + firstName + " " + lastName + "\n" + 
                "Test Scores: " + courses[0].getTestScore() + ", " + courses[1].getTestScore() + ", " + courses[2].getTestScore() + "\n" + 
                "Average Score: " + getAverage() + "\n";
        return result;
    }
    
    private Double getAverage(){ // get average score for student
        Double average = (courses[0].getTestScore() + courses[1].getTestScore() + courses[2].getTestScore()) / 3;
        return average;
    }
}
