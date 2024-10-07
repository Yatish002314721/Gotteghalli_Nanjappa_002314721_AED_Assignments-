/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 * @author USER
 */
public class PersonDirectory {
    private ArrayList<Person> personList;

    public PersonDirectory() {
        this.personList = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> accountList) {
        this.personList = accountList;
    }
    
    public Person addPerson() {
        Person account = new Person();
        personList.add(account);
        return account;
    }
    
    public void deletePerson(Person account) {
        personList.remove(account);
    }
    
    public Person searchPerson(String searchInput) {
        for(Person person: personList) {
            if(person.getFirstName().equals(searchInput) || person.getLastName().equals(searchInput) || person.getWorkAddress().getStreetAddress().equals(searchInput) || person.getHomeAddress().getStreetAddress().equals(searchInput)) {
                return person;
            }
        }
        return null;
    }
    
    
    
}
