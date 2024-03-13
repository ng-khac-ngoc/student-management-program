/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * The Student class represents information about a student. It implements the
 * Comparable interface to enable comparison based on student names.
 *
 * @author he151168
 */
public class Student implements Comparable<Student> {

    private String id;        // The student's ID
    private String name;      // The student's name
    private String semester;  // The semester the student is enrolled in
    private String course;    // The course the student is taking

    /**
     * Constructs a Student object with the provided information.
     *
     * @param id The student's ID.
     * @param name The student's name.
     * @param semester The semester the student is enrolled in.
     * @param course The course the student is taking.
     */
    public Student(String id, String name, String semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    /**
     * Get the student's ID.
     *
     * @return The student's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the student's ID.
     *
     * @param id The student's ID to set.
     * @return void
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the student's name.
     *
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the student's name.
     *
     * @param name The student's name to set.
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the semester the student is enrolled in.
     *
     * @return The semester.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Set the semester the student is enrolled in.
     *
     * @param semester The semester to set.
     * @return void
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the course the student is taking.
     *
     * @return The course.
     */
    public String getCourse() {
        return course;
    }

    /**
     * Set the course the student is taking.
     *
     * @param course The course to set.
     * @return void
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Returns a string representation of the `Student` object.
     *
     * @return A string representation in the format "Student{id, name,
     * semester, course}".
     */
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", semester=" + semester + ", course=" + course + '}';
    }

    /**
     * Compare this student to another student based on their names. Implements
     * the Comparable interface.
     *
     * @param student The student to compare to.
     * @return A negative integer, zero, or a positive integer if this student's
     * name is less than, equal to, or greater than the specified student's
     * name.
     */
    @Override
    public int compareTo(Student student) {
        return student.name.compareTo(this.name);
    }

    /**
     * Displays the student's information in a formatted manner.
     *
     * @return void
     */
    public void showInformation() {
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|\n",
                id, name, semester, course);
    }

}
