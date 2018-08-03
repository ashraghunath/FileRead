package com.company;

import org.apache.log4j.Logger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h1>Main class</h1>
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since 3-8-18
 */

public class Main {

    public static ArrayList<String> fileNamesList= new ArrayList<String>();
    public static ConcurrentHashMap<String,Employee> concurrentHashMap = new ConcurrentHashMap<String,Employee>();
    public static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Program has started");

        Timer timer = new Timer();
        timer.schedule(new InputFileNameThread(), 0,1);


    }


}
