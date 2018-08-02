package com.company;

import java.io.File;

public class FileExistOrNotThread extends Thread {

    String filePath;

    FileExistOrNotThread(String filePath){
        this.filePath = filePath;
    }

    public void run()
    {
        System.out.println("File Exist thread Running");
        System.out.println("FilePath recie"  + filePath);

        File toRead = new File(filePath);
        if(toRead.exists() && !toRead.isDirectory()){
            System.out.println("File Exist now you can run other threads hurray");

            CheckAttributeThread checkAttributeThread = new CheckAttributeThread(filePath);
              checkAttributeThread.start();
//
//                CheckDuplicatesThread checkDuplicatesThread = new CheckDuplicatesThread(filePath);
//                checkDuplicatesThread.start();
        }
        else if(toRead.isDirectory()){
            System.out.println("You typed directory, pls give file path");
        }
        else{
            System.out.println("File does not exists");
        }
    }


}
