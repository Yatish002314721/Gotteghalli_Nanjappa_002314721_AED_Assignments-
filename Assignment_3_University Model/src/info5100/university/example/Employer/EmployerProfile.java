/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Employer;

import info5100.university.example.Persona.EmploymentHistory.Employment;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployerProfile {
    String name;
    ArrayList<Employment> employments;
    public EmployerProfile(String n){  //could be company instead of just a name as a string
        name = n;
        
    }
         public boolean isMatch(String id){
        //String is an object and can do equal match
        if(name.equals(id)) return true;             
        return false;
    }
    
}
