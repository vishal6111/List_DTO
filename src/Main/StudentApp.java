package Main;

import DTO.StudentDto;
import Service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
    List<StudentDto> students = new ArrayList<>();
    StudentService studentResource = new StudentService(students);
    List<StudentDto> allStudents = studentResource.getAllStudent();
    Scanner sc = new Scanner(System.in);
    /**
     * Variables
     */
    int st_id;
    String st_name;
    String st_age;
    int input;

    /**
     * Main Method
     *
     * @param args : args
     */
    public static void main(String[] args) {
        StudentApp St_obj = new StudentApp();
        St_obj.For_records();
    }

    /**
     * TO print all the details
     *
     * @param allStudents : allStudents
     */
    private static void printStudentDetails(List<StudentDto> allStudents) {
        allStudents.forEach(student -> System.out.println(student.getId() + " " + student.getName() + " " + student.getAge()));
    }

    /**
     * To Add the Details
     */
    public void Add() {
        System.out.println("Enter the Id ");
        st_id = Integer.parseInt(sc.next());
        System.out.println("Enter the Name");
        st_name = sc.next();
        System.out.println("Enter the Age");
        st_age = sc.next();
        StudentDto st_obj = new StudentDto(st_id, st_name, st_age);
        students.add(st_obj);
        printStudentDetails(allStudents);
    }

    /**
     * To delete the record
     */
    public void delete() {
        System.out.println("What you want to delete");
        System.out.println("1. Delete By ID");
        System.out.println("2. Delete all");
        System.out.println("3. Back");
        input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("Which Student you want to delete");
                printStudentDetails(allStudents);
                System.out.println("Enter ID");
                st_id = Integer.parseInt(sc.next());
                studentResource.delete(st_id);
                allStudents = studentResource.getAllStudent();
                printStudentDetails(allStudents);
                delete();
                break;
            case 2:
                studentResource.deleteAll();
                allStudents = studentResource.getAllStudent();
                System.out.println("Empty List");
                delete();
                break;
            case 3:
                For_records();
                break;
        }
    }

    /**
     * To update existing record
     */
    public void update() {
        System.out.println("What you want to Update");
        System.out.println("1. Update Name");
        System.out.println("2. update Age");
        System.out.println("3. Update All");
        System.out.println("4. Back");
        input = sc.nextInt();

        switch (input) {
            case 1:
                printStudentDetails(allStudents);
                System.out.println("Enter Id");
                st_id = sc.nextInt();
                System.out.println("Enter updated name");
                st_name = sc.next();

                studentResource.update_name(st_id, st_name, allStudents);
                allStudents = studentResource.getAllStudent();
                printStudentDetails(allStudents);
                update();
                break;

            case 2:
                printStudentDetails(allStudents);
                System.out.println("Enter ID");
                st_id = sc.nextInt();
                System.out.println("Enter updated Age");
                st_age = sc.next();
                studentResource.update_age(st_id, st_age, allStudents);
                allStudents = studentResource.getAllStudent();
                printStudentDetails(allStudents);
                update();
                break;

            case 3:
                printStudentDetails(allStudents);
                System.out.println("Enter ID");
                st_id = sc.nextInt();
                System.out.println("Enter updated name");
                st_name = sc.next();
                System.out.println("Enter updated Age");
                st_age = sc.next();

                studentResource.update_All(st_id, st_name, st_age, allStudents);
                allStudents = studentResource.getAllStudent();
                printStudentDetails(allStudents);
                update();
                break;

            case 4:
                For_records();
                break;
        }
    }

    /**
     * TO show the all details
     */
    public void show() {
        List<StudentDto> allstudents = studentResource.getAllStudent();
        printStudentDetails(allstudents);
    }

    /**
     * To Update student details in List
     */
    public void For_records() {
        System.out.println("Enter a Value Which you want to perform operation");
        System.out.println("1. Insert Value");
        System.out.println("2. Delete Value");
        System.out.println("3. Update Value");
        System.out.println("4. View all value");
        input = sc.nextInt();

        switch (input) {
            case 1:
                Add();
                For_records();
                break;
            case 2:
                delete();
                For_records();
                break;
            case 3:
                update();
                For_records();
                break;
            case 4:
                show();
                For_records();
                break;
        }
    }
}
