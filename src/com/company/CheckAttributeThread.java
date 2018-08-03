package com.company;

/**
 * <h1>CheckAttributeThread class</h1>
 * Checks if all attributes are present
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since 3-8-18
 */
public class CheckAttributeThread extends Thread {

    String[] fileData;
    CheckAttributeThread(String[] fileData){
        this.fileData= fileData;
    }
    public void run(){


        try{

                if(fileData.length!=5){
                    Main.logger.debug("All attributes not present for record " );
                }
                else if (fileData.length==5){
                        CheckDobThread checkDobThread = new CheckDobThread(fileData);
                        checkDobThread.start();

                }


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
