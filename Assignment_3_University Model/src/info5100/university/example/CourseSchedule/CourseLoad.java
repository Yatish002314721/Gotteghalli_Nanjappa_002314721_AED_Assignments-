/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import java.util.ArrayList;

/**
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatAssignments;

    public CourseLoad(String s) {
        seatAssignments = new ArrayList();
        semester = s;
    }

    public SeatAssignment newSeatAssignment(CourseOffer co) {

        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat == null) {
            return null;
        }

        SeatAssignment sa = seat.newSeatAssignment(this);
        seatAssignments.add(sa);  //add to students course
        System.out.println("Seat assigned for course: ");
        return sa;
    }

    public void registerStudent(SeatAssignment sa) {

        sa.assignSeatToStudent(this);
        seatAssignments.add(sa);
    }

    public float getSemesterScore() { //total score for a full semeter
        float sum = 0;
        for (SeatAssignment sa : seatAssignments) {
            sum = sum + sa.GetCourseStudentScore();
        }
        return sum;
    }

    public ArrayList<SeatAssignment> getSeatAssignments() {
        return seatAssignments;
    }

    public String getSemester() {
        return semester;
    }
}
