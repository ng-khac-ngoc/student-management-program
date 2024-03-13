/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * The Report class represents a student report, including the student's ID,
 * name, course, and the total number of courses they have taken.
 *
 * @author he151168
 */
public class Report {

    private String id;               // Student ID
    private String studentName;      // Student name
    private String studentCourse;    // Course name
    private int totalCourse;         // Total number of courses

    /**
     * Constructs a new `Report` instance with the specified parameters.
     *
     * @param id The student's ID.
     * @param studentName The student's name.
     * @param studentCourse The course name.
     * @param totalCourse The total number of courses taken by the student.
     */
    public Report(String id, String studentName, String studentCourse, int totalCourse) {
        this.id = id;
        this.studentName = studentName;
        this.studentCourse = studentCourse;
        this.totalCourse = totalCourse;
    }

    /**
     * Gets the student's ID.
     *
     * @return The student's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the student's ID.
     *
     * @param id The student's ID.
     * @return void
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the student's name.
     *
     * @return The student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the student's name.
     *
     * @param studentName The student's name.
     * @return void
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets the course name.
     *
     * @return The course name.
     */
    public String getStudentCourse() {
        return studentCourse;
    }

    /**
     * Sets the course name.
     *
     * @param studentCourse The course name.
     * @return void
     */
    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    /**
     * Gets the total number of courses taken by the student.
     *
     * @return The total number of courses taken.
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    /**
     * Sets the total number of courses taken by the student.
     *
     * @param totalCourse The total number of courses.
     * @return void
     */
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

}
