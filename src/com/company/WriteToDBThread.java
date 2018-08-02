package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;

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

            //inserting value
            stmt.executeUpdate("insert into employee values ('ASASASK','SAD','SADBSN','ASDSBA','ASJD')");


            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
