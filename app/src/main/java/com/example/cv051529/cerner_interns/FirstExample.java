package com.example.cv051529.cerner_interns;

import android.util.Log;
import android.view.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by DR051643 on 6/19/2017.
 */
class FirstExample {
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/intern_app?user=" + USER + "password=" + PASS;

    static String tag = "DataBase";

    private View outputView;

    public String[] myMain() {
        Connection conn = null;
        Statement stmt = null;
        String messages[];
        ArrayList<String> outputMessages = new ArrayList<String>();
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            Log.i(tag,"Connecting to database...");
            outputMessages.add("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            Log.i(tag,"Creating statement...");
            outputMessages.add("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT title, description, date, email FROM question";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String title  = rs.getString("title");
                String description = rs.getString("age");
                String date = rs.getString("date");
                String email = rs.getString("email");

                //Display values
                System.out.print("Title: " + title);
                System.out.print(", Description: " + description);
                System.out.print(", Date: " + date);
                System.out.println(", Email: " + email);
                Log.i(tag,"Title: " + title);
                Log.i(tag,"Description: " + description);
                Log.i(tag,"Date: " + date);
                Log.i(tag,"Email: " + email);
                outputMessages.add("Title: " + title);
                outputMessages.add("Description: " + description);
                outputMessages.add("Date: " + date);
                outputMessages.add("Email: " + email);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            outputMessages.add("SE Failure 1: " + se.getMessage());
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            outputMessages.add("Exc Failure 1: " + e.getMessage());
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
                outputMessages.add("SE Failure 2: " + se.getMessage());
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        Log.i(tag,"Goodbye!");
        outputMessages.add("Goodbye");
        messages = new String[outputMessages.size()];
        messages = outputMessages.toArray(messages);
        return messages;
    }//end main

    public String[] getColumn(String table, String column, String selection)
    {
        Connection conn = null;
        Statement stmt = null;

        ArrayList<String> returnList = new ArrayList<String>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            Log.i(tag, "Connecting to database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            Log.i(tag, "Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT " + column +" FROM " + table;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                returnList.add(rs.getString(column));
            }
        }
        catch (SQLException e)
        {
            Log.e(tag,e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e(tag,e.getMessage());
        }
        String strList[] = new String[returnList.size()];
        strList = returnList.toArray(strList);
        return strList;
    }

}//end FirstExample

