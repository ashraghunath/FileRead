package com.company;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CheckDuplicatesThread extends Thread {

    Employee employee;

    CheckDuplicatesThread(Employee employee) {
        this.employee = employee;

    }

    public void run() {
        System.out.println(Thread.currentThread().toString());
        if(!Main.concurrentHashMap.containsKey(employee.getEmail())) {
            System.out.println("adding to concurrentHashMap");
            Main.concurrentHashMap.put(employee.getEmail(), employee);

            WriteToDBThread writeToDBThread = new WriteToDBThread(employee);
            writeToDBThread.start();
        }

        for(ConcurrentHashMap.Entry<String, Employee> temp : Main.concurrentHashMap.entrySet()){
            System.out.println("Key " +  temp.getKey().toString());
            System.out.println("Value " + temp.getValue().toString());
        }

        }

//    write to db here
    }


