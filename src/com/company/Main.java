package com.company;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static ConcurrentHashMap<String,Employee> concurrentHashMap = new ConcurrentHashMap<String,Employee>();

    public static void main(String[] args) throws IOException {

        Timer timer = new Timer();

        Calendar a = Calendar.getInstance();

        a.getTimeInMillis();
        timer.schedule(new InputFileNameThread(), 0, 1 * 1000);


        while(concurrentHashMap.size()<=3){
            if(concurrentHashMap.size() ==0) {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(concurrentHashMap.size()==3){

                for(String key : concurrentHashMap.keySet() ){

                    System.out.println(key);
                }
                break;
            }
//                System.out.println(concurrentHashMap.size());

        }


    }
}
