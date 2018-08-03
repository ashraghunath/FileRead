package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * <h1>FileExistOrNotThread class</h1>
 * checks if file given exists
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since 3-8-18
 */
public class FileExistOrNotThread extends Thread {

    String filePath;

    FileExistOrNotThread(String filePath){
        this.filePath = filePath;
    }

    public void run()
    {
        Main.logger.debug("FilePath received"  + filePath);

        File toRead = new File(filePath);
        if(toRead.exists() && !toRead.isDirectory()){

            Main.logger.info("File Exist");
            Main.fileNamesList.add(filePath);

            BufferedReader br = null;
            try{
                String sCurrentLine;
                br = new BufferedReader(new FileReader(filePath));

                int i=0;
                while ((sCurrentLine = br.readLine()) != null) {
                    String[] arr = sCurrentLine.split(" ");
                    if(arr.length!=5){
                        Main.logger.debug("All attributes not present for record " + arr);
                    }
                    else if (arr.length==5){
                        CheckAttributeThread checkAttributeThread = new CheckAttributeThread(arr);
                        checkAttributeThread.start();


                    }
                    i++;
                }

            }
            catch(Exception e){
                e.printStackTrace();
            }


        }
        else if(toRead.isDirectory()){
            System.out.println("You typed directory, pls give file path");
        }
        else {
            try {
                throw new FileDoesNotExistException("File does not exist");
            } catch (Exception message) {
                System.out.println(message.getMessage());
            }
        }
    }




}
