package com.company;

import java.util.Calendar;
import java.util.Scanner;
import java.util.TimerTask;

public class InputFileNameThread extends TimerTask {

    static Calendar calendar  = Calendar.getInstance();

    private static final long TENMINUTESINMILLI = 60000;


    public void run(){
        Calendar temp = Calendar.getInstance();
        System.out.println("calendar " + calendar.getTimeInMillis());
        System.out.println("TENMINUTESINMILLI " + TENMINUTESINMILLI);
        System.out.println("getTimeInMillis " + temp.getTimeInMillis());
        System.out.println("added " + (calendar.getTimeInMillis() + TENMINUTESINMILLI ));
        boolean condition = ((calendar.getTimeInMillis() + TENMINUTESINMILLI) > temp.getTimeInMillis());
        System.out.println(condition);
        if(condition) {
            System.out.println(calendar.get(Calendar.SECOND));

            System.out.println("Enter the File Name to Read from");
            Scanner scanner = new Scanner(System.in);

            String fileName = scanner.nextLine();
            System.out.println("File Name is received is :" + fileName);
            FileExistOrNotThread fileExistOrNotThread = new FileExistOrNotThread(fileName);
            fileExistOrNotThread.start();
        }
        else{
            System.out.println("Time up dude, its 10 minutes");
            System.exit(0);
        }
    }
}
