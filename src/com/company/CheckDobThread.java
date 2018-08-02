package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CheckDobThread extends Thread {

    String fileName;

    CheckDobThread(String fileName){
        this.fileName = fileName;
        }

    public void run(){
        BufferedReader br = null;

        try{
            String sCurrentLine;
            br = new BufferedReader(new FileReader(fileName));

            int i=0;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split(" ");
                System.out.println("fname = " + arr[0]);
                    if (arr[4] == null) {
                        System.out.println("Date NOt present");
                    }


                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                sdf.setLenient(false);


                try {

                    //if not valid, it will throw ParseException
                    Date date = sdf.parse(arr[4]);
                    System.out.println(date);

                } catch (ParseException e) {

                    e.printStackTrace();

                }

                i++;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
