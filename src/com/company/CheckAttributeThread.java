package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CheckAttributeThread extends Thread {

    String fileName;
    CheckAttributeThread(String fileName){
        this.fileName = fileName;
    }
    public void run(){
        BufferedReader br = null;

        try{
            String sCurrentLine;
            br = new BufferedReader(new FileReader(fileName));

            int i=0;
            while ((sCurrentLine = br.readLine()) != null) {
                Employee employee = new Employee();
                String[] arr = sCurrentLine.split(" ");
                if(arr.length!=5){
                    System.out.println("All attributes not present");
                }
                else if (arr.length==5){
                    employee.setFname(arr[0]);
                    employee.setLname(arr[1]);
                    employee.setEmail(arr[2]);
                    employee.setNumber(arr[3]);
                    Date date=new SimpleDateFormat("MM-DD-yyyy").parse(arr[4]);
                    employee.setDate(date);

                    CheckDuplicatesThread checkDuplicatesThread = new CheckDuplicatesThread(employee);
                    checkDuplicatesThread.start();

                }
                i++;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
