package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h1>CheckDobThread class</h1>
 * Checks if file has duplicate records
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since 3-8-18
 */
public class CheckDobThread extends Thread {

    String[] fileData;

    CheckDobThread(String[] fileData){
        this.fileData = fileData;
        }

    public void run(){

                try {
                    Employee employee = new Employee();
                    if (fileData.length != 5) {
                        System.out.println("Date not present");

                    } else {
                        employee.setFname(fileData[0]);
                        employee.setLname(fileData[1]);
                        employee.setEmail(fileData[2]);
                        employee.setNumber(fileData[3]);

                        SimpleDateFormat sdfrmt = new SimpleDateFormat("MM-dd-yyyy");
                        sdfrmt.setLenient(false);

                        Date date = sdfrmt.parse(fileData[4]);
                        employee.setDate(date);

                        CheckDuplicatesThread checkDuplicatesThread = new CheckDuplicatesThread(employee);
                        checkDuplicatesThread.start();
                    }

                }catch (ParseException e){
                    throw new DOBformatException("DOB format exception");
                }catch(Exception e) {
                    e.printStackTrace();
                }


    }

}
