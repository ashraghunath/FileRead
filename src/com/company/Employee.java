package com.company;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Employee implements Serializable {


    String fname;
    String lname;
    String email;
    String number;
    Date date;

    public Employee(){

    }

    public Employee(String fname, String lname, String email, String number, Date date) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.number = number;

        this.date = date;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(email, employee.email);

    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }
}
