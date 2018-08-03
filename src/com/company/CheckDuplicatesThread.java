package com.company;


/**
 * <h1>CheckDuplicatesThread class</h1>
 * Checks if file has duplicate records
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since 3-8-18
 */
public class CheckDuplicatesThread extends Thread {

    Employee employee;

    CheckDuplicatesThread(Employee employee) {
        this.employee = employee;

    }

    public void run() {
        if(!Main.concurrentHashMap.containsKey(employee.getEmail())) {
            Main.concurrentHashMap.put(employee.getEmail(), employee);

            WriteToDBThread writeToDBThread = new WriteToDBThread(employee);
            writeToDBThread.start();
        }

        }

    }


