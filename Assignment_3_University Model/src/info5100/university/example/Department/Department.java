/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Degree.Degree;
import info5100.university.example.Employer.EmployerDirectory;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    static StudentDirectory studentDirectory;
    FacultyDirectory facultydirectory;
    EmployerDirectory employerdirectory;
    Degree degree;

    HashMap<String, CourseSchedule> masterCourseCatalogMap;

    public Department(String n) {
        name = n;
        masterCourseCatalogMap = new HashMap<>();
        coursecatalog = new CourseCatalog(this);
        studentDirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        facultydirectory = new FacultyDirectory(this);
        degree = new Degree("MSIS");

    }

    public void addCoreCourse(Course c) {
        degree.addCoreCourse(c);

    }

    public String getName() {
        return name;
    }

    public void addElectiveCourse(Course c) {
        degree.addElectiveCourse(c);

    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
        return studentDirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        masterCourseCatalogMap.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return masterCourseCatalogMap.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = masterCourseCatalogMap.get(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentId, String cn, String semester) {

        StudentProfile sp = studentDirectory.findStudent(studentId);
        if (sp == null) {
            System.out.println("Student not found");
            System.out.println("Do you want to add a new student? (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("yes")) {
                Person person = persondirectory.newPerson(studentId);
                sp = studentDirectory.newStudentProfile(person);
                sp.newCourseLoad(semester);
            } else {
                return;
            }
        }
        CourseLoad cl = sp.getCourseLoadBySemester(semester);
        if (cl == null) {
            cl = sp.newCourseLoad(semester);
        }
        CourseSchedule cs = masterCourseCatalogMap.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);
        cl.newSeatAssignment(co); //register student for course

        System.out.println("Student: " + sp.getPerson().getPersonId() + " registered for " + co.getCourseNumber() + " for " + semester);

    }

    public void setCourseCatalog(CourseCatalog coursecatalog) {
        this.coursecatalog = coursecatalog;
    }

    public Course addCourse(String courseName, String courseNumber, int credits, String semester) {
//        check if course already exists
        Course course = newCourse(courseName, courseNumber, credits);
        CourseSchedule cs = masterCourseCatalogMap.get(semester);
        if (cs.getCourseOfferByNumber(courseNumber) != null) {
            System.out.println("Course already exists in this semester");
            return null;
        }

        cs.setCoursecatalog(coursecatalog);
        cs.newCourseOffer(courseNumber);
        cs.generateSeats(courseNumber);
        return course;
    }

    public void browseCourses(String semester) {
        CourseSchedule courseSchedule = masterCourseCatalogMap.get(semester);

        ArrayList<Course> courses = courseSchedule.getCourseCatalog().getCourseList();
        for (Course c : courses) {
            System.out.println(c.getCourseNumber() + " " + c.getCourseName());
        }
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;
    }

    public void addFaculty(Person person, CourseOffer co) {
        FacultyProfile fp = facultydirectory.newFacultyProfile(person);
        fp.AssignAsTeacher(co);
        co.AssignAsTeacher(fp);
        System.out.println("Faculty added: " + person.getPersonId() + " for " + co.getSubjectCourse().getCourseName());
    }

    public void printReport(String semester) {
        System.out.println("Report for " + semester);
        System.out.println("Students and their course registration for a semester");
        System.out.println("--------------------------------------------------------------------------------------");
        ArrayList<StudentProfile> sl = studentDirectory.getStudentList();

        for (StudentProfile student : sl) {
            Person studentPerson = student.getPerson();
            CourseLoad courseLoad = student.getCourseLoadBySemester(semester);
            if (courseLoad == null) {
                continue; // Skip students who are not registered for any course in the semester
            }
            System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s%n", "Student ID", "Course", "Professor ID", "Grade", "Credits");
            System.out.println("--------------------------------------------------------------------------------------");
            ArrayList<SeatAssignment> sal = courseLoad.getSeatAssignments();
            int totalPrice = 0;
            float totalGrade = 0;
            int noOfCourse = 0;

            // Calculate total GPA and tuition for each student
            for (SeatAssignment sa : sal) {
                totalPrice += sa.getAssociatedCourse().getCoursePrice();
                totalGrade += sa.GetCourseStudentScore();
                noOfCourse += 1;

                Course c = sa.getAssociatedCourse();
                CourseOffer co = sa.getCourseOffer();
                FacultyProfile fp = co.getFacultyProfile();
                // Print table row
                if (noOfCourse == 1) { // Print student ID only for the first course
                    System.out.printf("%-15s | %-15s | %-15s | %-15.2f | %-15s%n", studentPerson.getPersonId(), c.getCourseName(), fp.getPerson().getPersonId(), sa.GetCourseStudentScore(), c.getCredits());
                } else { // Print empty string for student ID for subsequent courses
                    System.out.printf("%-15s | %-15s | %-15s | %-15.2f | %-15s%n", "", c.getCourseName(), fp.getPerson().getPersonId(), sa.GetCourseStudentScore(), c.getCredits());
                }
            }
            if (noOfCourse == 0) {
                continue; // Skip students who are not registered for any course in the semester
            }
            // Print student's total GPA and tuition
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("%-15s | %-15s%n", "GPA:", totalGrade / noOfCourse);
            System.out.printf("%-15s | %-15s%n", "Tuition:", totalPrice);
            System.out.println("--------------------------------------------------------------------------------------");

        }
    }

    public void printSemesters() {
        for (String semester : masterCourseCatalogMap.keySet()) {
            System.out.println("Semester: " + semester);
        }
    }
}
