package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.Common;
import doituong.FQA;

public class FQAModel {

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;

    public List<FQA> getAllFQA() {
        Connection conn = null;
        Statement stmt = null;
        List<FQA> listFQA = new ArrayList<FQA>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From fqa";

            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);

            
            FQA fqaObject;

            while (resultSet.next()) {
                fqaObject = new FQA(resultSet.getInt("id"), resultSet.getString("question"), resultSet.getString("answer"));
                listFQA.add(fqaObject);
            }

            return listFQA;

        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return listFQA;
    }
}
