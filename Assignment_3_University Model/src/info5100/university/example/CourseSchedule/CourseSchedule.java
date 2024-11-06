/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;

import java.util.ArrayList;

/**
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList<>();

    }

    public CourseOffer newCourseOffer(String n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if (c == null) {
            System.out.println("Course not found");
            return null;
        }
        CourseOffer co;
        co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {
        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

    //    add schedule:
    public void generateSchedule() {
        ArrayList<Course> courses = coursecatalog.getCourseList();
        for (Course c : courses) {
            CourseOffer co = new CourseOffer(c);
            co.generateSeats(50);
            schedule.add(co);
        }
    }

    public void generateSeats(String courseNumber) {
        CourseOffer co = getCourseOfferByNumber(courseNumber);
        co.generateSeats(50);
    }

    public void setCoursecatalog(CourseCatalog coursecatalog) {
        this.coursecatalog = coursecatalog;
    }

    public CourseCatalog getCourseCatalog() {
        return coursecatalog;
    }

    public ArrayList<CourseOffer> getCourseOffers() {
        return schedule;
    }
}
