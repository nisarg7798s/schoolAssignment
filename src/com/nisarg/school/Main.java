package com.nisarg.school;

import java.util.Scanner;

import static com.nisarg.school.SchoolType.*;

public class Main {
    static School preSchool = new PreSchool();
    static School elementarySchool = new ElementarySchool();
    static School middleSchool = new MiddleSchool();
    static School highSchool = new HighSchool();

    public static void main(String[] args) {
        //1. Show the prompts on console  - done
        System.out.println("Welcome to School Admissions App, Press X for Exit");
        System.out.println("Enter the name of the student");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter the age of the student");
        Integer age = scanner.nextInt();
        System.out.println("name: " + name + "age:" + age);
        //3. determine name is not too long/short , also age is not too low/high
        if (name.length() >= 50 || name.length() < 3) {
            System.out.println("name is too long or too short ");
        }
        if (age < 4 || age > 17) {
            System.out.println("age is too low or too high ");
        }
        //4. determineGradeBasedOnage()
        GradeType grade = null;
        try {
            grade = determineGradeBasedOnAge(age);
        } catch (AgeNotCorrectException e) {
            System.out.println(" age is too high or too low");
        }
        //5. determineSchoolBasedOnGrade()
        SchoolType schoolType = null;
        try {
            schoolType = determineSchoolBasedOnGrade(grade);
        } catch (GradeNotCorrectException e) {
            System.out.println(" grade not correct , please fix");
        }
        //6. schooladmitStudent()
        Student student = new Student(name, age, grade);
        School school = retrieveSchoolObjectBasedOnSchoolType(schoolType);
        try {
            school.admitStudent(student);
        } catch (ClassFullException e) {
            System.out.println("Sorry the class for grade#" + grade + " is full, please try another student");
        }
        System.out.println("welcome ... ");



    }

    private static School retrieveSchoolObjectBasedOnSchoolType(SchoolType schoolType) {
        switch (schoolType) {
            case HIGH_SCHOOL:
                return highSchool;
            case ELEMENTARY_SCHOOL:
                return elementarySchool;
            case MIDDLE_SCHOOL:
                return middleSchool;
            case PRE_SCHOOL:
                return preSchool;
            default:
                throw new IllegalArgumentException("wrong school type");
        }
    }

    private static SchoolType determineSchoolBasedOnGrade(GradeType grade) throws GradeNotCorrectException {
        switch (grade) {
            case JK_GRADE:
            case SK_GRADE:
                return PRE_SCHOOL;
            case GRADE_1:
            case SECOND_GRADE:
            case THIRD_GRADE:
            case FOURTH_GRADE:
            case FIFTH_GRADE:
                return ELEMENTARY_SCHOOL;
            case SIXTH_GRADE:
            case SEVENTH_GRADE:
            case EIGHTH_GRADE:
                return MIDDLE_SCHOOL;
            case NINTH_GRADE:
            case TENTH_GRADE:
            case ELEVENTH_GRADE:
            case TWELFTH_GRADE:
                return HIGH_SCHOOL;
            default:
                throw new GradeNotCorrectException();
        }
    }

    private static GradeType determineGradeBasedOnAge(int age) throws AgeNotCorrectException {
        System.out.println("determining grade done");
        switch (age) {
            case 4:
                return GradeType.JK_GRADE;
            case 5:
                return GradeType.SK_GRADE;
            case 6:
                return GradeType.GRADE_1;
            case 7:
                return GradeType.SECOND_GRADE;
            case 8:
                return GradeType.THIRD_GRADE;
            case 9:
                return GradeType.FOURTH_GRADE;
            case 10:
                return GradeType.FIFTH_GRADE;
            case 11:
                return GradeType.SIXTH_GRADE;
            case 12:
                return GradeType.SEVENTH_GRADE;
            case 13:
                return GradeType.EIGHTH_GRADE ;
            case 14:
                return GradeType.NINTH_GRADE;
            case 15:
                return GradeType.TENTH_GRADE;
            case 16:
                return GradeType.ELEVENTH_GRADE;
            case 17:
                return GradeType.TWELFTH_GRADE;
            default:
                throw new AgeNotCorrectException("age has to be between 4 and 17");
        }
    }
}
