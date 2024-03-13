/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import data.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import validate.Validate;

/**
 * The Management class handles the core functionality of the Student Management
 * System. It allows creating, finding, updating, deleting students, and
 * generating reports.
 *
 * @author he151168
 */
public class Management {

    private ArrayList<Student> listStudent = new ArrayList();
    private ArrayList<Report> listReport = new ArrayList();

    private Scanner scan = new Scanner(System.in);

    /**
     * Displays the main menu of the Student Management System and handles user
     * interactions.
     *
     * @return void
     */
    public void displayMenu() {
        while (true) {
            System.out.println("=======Student Management System======");
            System.out.println("1. Create students");
            System.out.println("2. Find and Sort students");
            System.out.println("3. Update and Delete students");
            System.out.println("4. Report");
            System.out.println("5. Exit");

            // Get user's choice (between 1 and 5)
            int choice = Validate.getChoice(1, 5);

            // Handle the user's choice
            switch (choice) {
                case 1:
                    // Create students
                    System.out.println("-------- Create students --------");
                    createStudent();
                    break;
                case 2:
                    // Find and Sort students
                    System.out.println("-------- Find and Sort students --------");
                    findAndSort();
                    break;
                case 3:
                    // Update and Delete students
                    System.out.println("-------- Update and Delete students --------");
                    updateOrDelete();
                    break;
                case 4:
                    // Report
                    System.out.println("-------- Report --------");
                    report();
                case 5:
                    // Exit the program
                    System.out.println("-------- See you soon --------");
                    return;
            }
        }
    }

    /**
     * Creates new students and adds them to the list of students.
     *
     * @return void
     */
    public void createStudent() {
        while (true) {
            String id;
            String name;
            String semester;
            String course;

            // Ensure the entered student ID is unique
            while (true) {
                id = Validate.getString("Enter id: ", "id must not be empty and id just a format string");

                // Check if an student with the same ID already exists
                if (searchStudent(id) == null) {
                    break;
                } else {
                    System.out.println("Student already exist. Please enter another one: ");
                }
            }

            // Prompt for student name, semester, and course
            System.out.print("Enter name: ");
            name = Validate.getString();
            System.out.print("Enter semester: ");
            semester = Validate.getString();
            course = Validate.checkInputCourse("Enter course: ");

            // Create a new Student instance and add it to the list of students
            listStudent.add(new Student(id, name, semester, course));

            // Display success message
            System.out.println("Add student #" + listStudent.size() + " success");

            // Check if the user wants to continue adding more students
            if (listStudent.size() > 10) {
                boolean yesOrNo = Validate.checkInputYesNo("Do you want to continue: ");
                if (!yesOrNo) {
                    break;
                }
            }
        }
    }

    /**
     * Searches for a student by their ID.
     *
     * @param id The ID of the student to search for.
     * @return The student with the given ID, or null if not found.
     */
    public Student searchStudent(String id) {

        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equalsIgnoreCase(id)) {
                return listStudent.get(i);
            }
        }
        // If no student with the given ID is found, return null
        return null;
    }

    /**
     * Finds and sorts students by name, then displays the results.
     *
     * @return void
     */
    public void findAndSort() {
        if (listStudent.isEmpty()) {
            System.out.println("List not have any student");
            return;
        }

        // Search for students by name and store the results in a list
        ArrayList<Student> listStudentFindByName = listStudentFindByName(listStudent);

        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not exist.");
        } else {
            // Sort the found students by name
            Collections.sort(listStudentFindByName);

            // Display the header for the student information
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");

            // Loop through and display information for each student
            for (Student student : listStudentFindByName) {
                student.showInformation();
            }
        }
    }

    /**
     * Filters the list of students by name.
     *
     * @param listStudent The list of students to filter.
     * @return A list of students matching the given name.
     */
    public ArrayList<Student> listStudentFindByName(ArrayList<Student> listStudent) {
        ArrayList<Student> listStudentFindByName = new ArrayList();

        // Prompt the user to enter the name to search for
        System.out.print("Enter name to search: ");
        String name = Validate.getString();

        // Loop through the provided list of students
        for (Student student : listStudent) {
            // Check if the student's name contains the search name
            if (student.getName().contains(name)) {
                // Add the student to the list if their name matches the search criteria
                listStudentFindByName.add(student);
            }
        }

        // Return the list of students whose names contain the search name
        return listStudentFindByName;
    }

    /**
     * Allows the user to update or delete a student's information. The user is
     * prompted to enter the student's ID to identify the student. If the
     * student is found, the user can choose to update the student's information
     * (ID, name, semester, and course) or delete the student from the list.
     *
     * @return void
     */
    public void updateOrDelete() {
        //Checks if the listStudent is empty
        if (listStudent.isEmpty()) {
            System.out.println("List not have any student");
            return; // End the method if the list is empty
        }

        // Prompt the user to enter the ID of the student to update or delete
        String id = Validate.getString("Enter id: ", "id must not be empty and id just a format string");
        // Search for the student with the provided ID
        Student student = searchStudent(id);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            // Prompt the user to choose between updating or deleting the student
            boolean checkUpdateDelete = Validate.checkInputUpdateDelete("Do you want update or delete: ");

            if (checkUpdateDelete) {
                // Prompt the user to enter the new ID, name, semester, and course
                String newID = Validate.getString("Enter new id that you want to update: ", "id must not be empty and id just a format string");
                String newName = Validate.getString("Enter new name that you want to update: ", "Name must not be empty and id just a format string");
                String newSemester = Validate.getString("Enter new semester that you want to update: ", "Semester must not be empty and id just a format string");
                String newCourse = Validate.checkInputCourse("Enter course that you want to update: ");

                // Update information of the student if found
                student.setId(newID);
                student.setName(newName);
                student.setSemester(newSemester);
                student.setCourse(newCourse);
                System.out.println("Update information of student sucessful");
            } else {
                // Remove the student from the list
                listStudent.remove(student);
                System.out.println("Delete student sucessful");
            }
        }
    }

    /**
     * Checks if a report with the same student ID, course name, and total
     * already exists.
     *
     * @param id The student ID.
     * @param courseName The course name.
     * @param total The total count.
     * @return true if a report with the same details does not exist, false
     * otherwise.
     */
    public boolean checkReport(String id, String courseName, int total) {
        for (Report report : listReport) {
            // Check if a report with the same ID, course name, and total already exists
            if (id == report.getId() && courseName.equalsIgnoreCase(report.getStudentCourse()) && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Generates and displays a report showing the number of students per
     * course. Checks if the list of students is empty and terminates if there
     * are no students. The report is stored in the list of reports, and each
     * report entry displays the student name, course name, and the total number
     * of students for that course.
     *
     * @return void
     */
    public void report() {
        //Checks if the listStudent is empty
        if (listStudent.isEmpty()) {
            System.out.println("List not have any student");
            return; // End the method if the list is empty
        }
        for (Student student : listStudent) {
            int total = 0;
            String id = student.getId();
            String studentName = student.getName();
            String courseName = student.getCourse();
            if (checkReport(id, courseName, total)) {
                listReport.add(new Report(id, studentName, courseName, total + 1));
            } else {
                for (Report report : listReport) {
                    if (student.getId().equalsIgnoreCase(report.getId()) && report.getStudentCourse().equalsIgnoreCase(courseName)) {
                        total++;
                        report.setId(id);
                        report.setStudentName(studentName);
                        report.setStudentCourse(courseName);
                        report.setTotalCourse(total);
                    }
                }
            }
        }

        // Display the report
        for (int i = 0; i < listReport.size(); i++) {
            System.out.printf("%-13s|%-6s|%2d\n", listReport.get(i).getStudentName(), listReport.get(i).getStudentCourse(), listReport.get(i).getTotalCourse());
        }
    }

}
