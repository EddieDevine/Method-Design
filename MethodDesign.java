/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.methoddesign;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author edevine2025
 */
public class MethodDesign {

    public static void main(String[] args) {
        System.out.println("Hello World!\n");
        
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Student> studentList = new ArrayList<>();
        
        boolean complete = false;
        while(!complete){
            Double[] scores = {0.0, 0.0, 0.0};
            String first, last;
            
            System.out.println("Add Student");
            
            System.out.print("First Name: ");
            first = scanner.nextLine();
            
            System.out.print("Last Name: ");
            last = scanner.nextLine();
            
            
            System.out.print("Score 1: ");
            scores[0] = Double.parseDouble(scanner.nextLine());
            System.out.print("Score 2: ");
            scores[1] = Double.parseDouble(scanner.nextLine());
            System.out.print("Score 3: ");
            scores[2] = Double.parseDouble(scanner.nextLine());
            
            Student newStudent = new Student(first, last, scores);
            studentList.add(newStudent);
            
            System.out.print("Add another student? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                complete = true;
            }
        }
        
        System.out.println("\nStudent List:");
        for(Student student : studentList) {
            System.out.println(student.toString());
        }
    }

}

class Course {
    private Double testScore;
    
    public Course(){
        testScore = 0.0;
    }
    
    public Course(Double inScore){
        testScore = inScore;
    }
    
    public Double getTestScore(){
        return testScore;
    }
    
    public void setTestScore(Double inScore){
        testScore = inScore;
    }
}

class Student {
    private String firstName, lastName;
    private Course[] courses;
    
    public Student(){
        firstName = "N/A";
        lastName = "N/A";
        courses = new Course[]{new Course(), new Course(), new Course()};
    }
    
    public Student(String first, String last, Double[] inScores){
        System.out.println(inScores[0]);
        firstName = first;
        lastName = last;
        courses = new Course[]{new Course(inScores[0]), new Course(inScores[1]), new Course(inScores[2])};
    }
    
    @Override
    public String toString(){
        String result;
        result = "Student: " + firstName + " " + lastName + "\n" + 
                "Test Scores: " + courses[0].getTestScore() + ", " + courses[1].getTestScore() + ", " + courses[2].getTestScore() + "\n" + 
                "Average Score: " + getAverage() + "\n";
        return result;
    }
    
    public Double getAverage(){
        Double average = (courses[0].getTestScore() + courses[1].getTestScore() + courses[2].getTestScore()) / 3;
        return average;
    }
}
