package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class StudentGrade{
    private ArrayList<Integer> gradesInputed;
    private ArrayList<String> namesOfStudents;
    int gradeACtr = 0;
    int gradeBCtr = 0;
    int gradeCCtr = 0;
    int gradeDCtr = 0;
    int gradeFCtr = 0;


    public StudentGrade(){
        this.gradesInputed = new ArrayList<>();
        this.namesOfStudents = new ArrayList<>();
    }

    public void addAndDisplayGrade(String name, int grade) {
       if (grade >= 90 && grade <= 100) {
           System.out.println(name + " got a Grade: A");
           gradeACtr++;
       } else if (grade >= 80 && grade <= 89) {
           System.out.println(name + " got a Grade: B");
           gradeBCtr++;
       } else if (grade >= 70 && grade <= 79) {
           System.out.println(name + " got a Grade: C");
           gradeCCtr++;
       } else if (grade >= 60 && grade <= 69) {
           System.out.println(name + " got a Grade: D");
           gradeDCtr++;
       } else {
           System.out.println(name + " got a Grade: F");
           gradeFCtr++;
       }

       gradesInputed.add(grade);
       namesOfStudents.add(name);
    }

    public void computeAndDisplaySummary(){
        if (!gradesInputed.isEmpty()){
            int sumOfGrades = 0;

            for(int grade: gradesInputed){
                sumOfGrades += grade;
            }

            System.out.println("----- Class Summary -----");
            System.out.print("Average Score: ");
            System.out.printf("%.2f", (double) sumOfGrades / gradesInputed.size());
            // Add new line
            System.out.println();
            System.out.println("Grade Counts: A:" + gradeACtr + " B:" + gradeBCtr + " C:" + gradeCCtr + " D:" + gradeDCtr + " F:" + gradeFCtr);

            int maxIndex = 0;
            int maxValue = gradesInputed.getFirst();

            for (int i = 1; i < gradesInputed.size(); i++) {
                if (gradesInputed.get(i) > maxValue) {
                    maxValue = gradesInputed.get(i);
                    maxIndex = i;
                }
            }

            System.out.println("Top Student(s): " + namesOfStudents.get(maxIndex) + " (" + maxValue + ")");
        } else {
            System.out.println("There are no inputed grades!");
        }
    }

}
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        StudentGrade studentGrade = new StudentGrade();
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int studentCount = inputReader.nextInt();

        for (int i = 0; i < studentCount; i++) {
            // Add new line
            System.out.println();

            System.out.print("Enter name of student " + (i+1) + ": ");
            String nameOfStudent = inputReader.next();
            System.out.print("Enter Score for " + nameOfStudent + ": ");
            int score = inputReader.nextInt();

            studentGrade.addAndDisplayGrade(nameOfStudent, score);

        }

        // Add New Line
        System.out.println();
        studentGrade.computeAndDisplaySummary();
    }
}