/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentProfile;

import java.util.Scanner;

/**
 * @author kal bugrara
 */
public class Info5001UniversityExample {

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // TODO code application logic here
        Department department = new Department("Information Systems");
        String semester = "Fall2020";
        CourseSchedule courseschedule = department.newCourseSchedule(semester);

        //create 1 core, and at least 5 electives
        Course course = department.addCourse("App Eng", "5100", 4, semester);
        department.addCoreCourse(course);
        Course course2 = department.addCourse("Web Design", "5101", 4, semester);
        department.addElectiveCourse(course2);
        Course course3 = department.addCourse("Data Structure", "5102", 4, semester);
        department.addElectiveCourse(course3);
        Course course4 = department.addCourse("Database", "5103", 4, semester);
        department.addElectiveCourse(course4);
        Course course5 = department.addCourse("Info Security", "5104", 4, semester);
        department.addElectiveCourse(course5);
        Course course6 = department.addCourse("Info System", "5105", 4, semester);
        department.addElectiveCourse(course6);

        //add 2 faculty for each course created above
        for (int i = 0; i < 6; i++) {
            Person person = department.getPersonDirectory().newPerson("0130" + i);
            CourseOffer courseoffer = courseschedule.getCourseOfferByNumber("510" + i);
            department.addFaculty(person, courseoffer);
        }

        //register student
        //create  10 students do for fall 2020
        for (int i = 0; i < 10; i++) {
            Person person = department.getPersonDirectory().newPerson("011230" + i);
            StudentProfile student = department.getStudentDirectory().newStudentProfile(person);
            student.newCourseLoad(semester);
            for (CourseOffer courseOffer : courseschedule.getCourseOffers()) {
                department.RegisterForAClass(student.getPerson().getPersonId(),
                        courseOffer.getCourseNumber(), semester);

            }
        }


        int total = department.calculateRevenuesBySemester("Fall2020");

        department.printReport(semester);
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1.  Register for a class");
            System.out.println("2.  Print report");
            System.out.println("3.  Add a course");
            System.out.println("4.  Add a semester");
            System.out.println("5.  Browse courses");
            System.out.println("6.  Calculate revenues by semester");
            System.out.println("7.  Add a faculty");
            System.out.println("8.  Get Faculty Profile");
            System.out.println("9. Get Student Profile");
            System.out.println("10. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // take in student id, course number, semester
                    System.out.println("Enter student id:");
                    String studentId = scanner.next();
                    System.out.println("Available Semesters:");
                    department.printSemesters();
                    System.out.println("Enter semester:");
                    String semester11 = scanner.next();
                    // Display list of courses
                    System.out.println("Available Courses in this semester:");
                    department.browseCourses(semester11);
                    System.out.println("Enter course number:");
                    String courseNumber = scanner.next();

                    // Register for a class
                    department.RegisterForAClass(studentId, courseNumber, semester11);
                    break;
                case 2:
                    // Print report for a semester
                    System.out.println("Available Semesters:");
                    department.printSemesters();
                    System.out.println("Enter semester:");
                    String semester12 = scanner.next();
                    department.printReport(semester12);
                    break;
                case 3:
                    // Add a course
                    System.out.println("Enter course name:");
                    String courseName = scanner.next();
                    System.out.println("Enter course number:");
                    String courseNumber1 = scanner.next();
                    System.out.println("Enter credits:");
                    int credits = scanner.nextInt();
                    System.out.println("Enter semester:");
                    String semester1 = scanner.next();
                    department.addCourse(courseName, courseNumber1, credits, semester1);
                    break;
                case 4:
                    // Add a semester
                    System.out.println("Enter semester:");
                    String semester2 = scanner.next();
                    department.newCourseSchedule(semester2);
                    break;
                case 5:
                    // Browse courses
                    System.out.println("Enter semester:");
                    String semester3 = scanner.next();
                    department.browseCourses(semester3);
                    break;
                case 6:
                    // Calculate revenues by semester
                    System.out.println("Enter semester:");
                    String semester4 = scanner.next();
                    int total1 = department.calculateRevenuesBySemester(semester4);
                    System.out.println("Total revenues for " + semester4 + ": " + total1);
                    break;
                case 7:
                    // Add a faculty
                    System.out.println("Enter course number:");
                    String courseNumber2 = scanner.next();
                    System.out.println("Enter semester:");
                    String semester5 = scanner.next();
                    CourseOffer courseOffer = department.getCourseSchedule(semester5).getCourseOfferByNumber(courseNumber2);
                    System.out.println("Enter faculty id:");
                    String facultyId = scanner.next();
                    Person person = department.getPersonDirectory().newPerson(facultyId);
                    department.addFaculty(person, courseOffer);
                    break;
                case 8:
                    // Get Faculty Profile
                    System.out.println("Enter course number:");
                    String courseNumber3 = scanner.next();
                    System.out.println("Enter semester:");
                    String semester6 = scanner.next();
                    CourseOffer courseOffer1 = department.getCourseSchedule(semester6).getCourseOfferByNumber(courseNumber3);
                    FacultyProfile facultyProfile = courseOffer1.getFacultyProfile();
                    System.out.println("Faculty Name: " + facultyProfile.getPerson().getPersonId());
                    break;
                case 9:
                    // Get Student Profile
                    System.out.println("Enter student id:");
                    String studentId1 = scanner.next();
                    StudentProfile studentProfile = department.getStudentDirectory().findStudent(studentId1);
                    System.out.println("Student Name: " + studentProfile.getPerson().getPersonId());
                    studentProfile.printTranscript();
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }
}
