package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * <h1>WriteToDBThread class</h1>
 * Maintains console for 10 minutes
 * @author  Ashwin Raghunath
 * @version 1.0
 * @since 3-8-18
 */
public class WriteToDBThread extends Thread {

    Employee employee;

    WriteToDBThread(Employee employee){
        this.employee = employee;

    }

    public void run(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_info", "root", "root");

            Statement stmt = con.createStatement();

            String fname = employee.getFname();
            String lname = employee.getLname();
            String email = employee.getEmail();
            String phone = employee.getNumber();
            String dateStr = employee.getDate().toString();
            DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
            Date d = (Date)formatter.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
            String date= formatedDate;

            stmt.executeUpdate("INSERT INTO `employee`(fname,lname,email,phone,date) VALUE ('"+fname+"','"+lname+"','"+email+"',"+phone+",'"+date+"')");
            Main.logger.info("Inserted into DB");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
