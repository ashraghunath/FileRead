package com.company;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TimerTask;
/**
 * <h1>InputFileNameThread class</h1>
 * Maintains console for 10 minutes
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since 3-8-18
 */
public class InputFileNameThread extends TimerTask {

    static Calendar calendar  = Calendar.getInstance();
    private static final long TENMINUTESINMILLI = 60000;


    public void run() {
        Calendar temp = Calendar.getInstance();
        boolean condition = ((calendar.getTimeInMillis() + TENMINUTESINMILLI) > temp.getTimeInMillis());
        String fileName = null;
        if (condition) {

            System.out.println("Enter the File Name to Read from");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.nextLine();

            Main.logger.debug("File Name is received is " + fileName);


            FileExistOrNotThread fileExistOrNotThread = new FileExistOrNotThread(fileName);
            fileExistOrNotThread.start();
        } else {
            System.out.println("Time up, its 10 minutes");
            //deleting files after completion
            try
            {
                Iterator<String> fileNamesListIterator = Main.fileNamesList.iterator();
                while (fileNamesListIterator.hasNext()) {
                    String filePath = fileNamesListIterator.next();
//                    System.out.println("Deleted " + filePath);
                   boolean deleted = Files.deleteIfExists(Paths.get(filePath));
                    if(deleted){
                        System.out.println("Deleted " + filePath);
                    }
                }

            } catch (Exception e) { }
            //exiting the program
            System.exit(0);
        }
    }

}
