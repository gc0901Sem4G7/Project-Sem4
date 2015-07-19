package model.admin;

import common.Common;
import doituong.DichVu;
import doituong.FQA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static model.DichVuModel.DB_URL;
import static model.DichVuModel.JDBC_DRIVER;
import static model.DichVuModel.PASSWORD;
import static model.DichVuModel.USERNAME;

public class AdminFQAModel{

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;
    
    public FQA getFQAById(int id,String tableName) {
        Connection conn = null;
        Statement stmt = null;
        FQA fqaObject = new FQA();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From " + tableName + " WHERE id = " + id;

            System.out.println(sql);
            ResultSet resultSetFQA = stmt.executeQuery(sql);

            while (resultSetFQA.next()) {
                fqaObject = new FQA(resultSetFQA.getInt("id"), resultSetFQA.getString("question"), resultSetFQA.getString("answer"), resultSetFQA.getString("username"), resultSetFQA.getString("status"));
            }

        } catch (Exception se) {

            se.printStackTrace();
        }
        return fqaObject;
    }
    
    public boolean update(FQA obj, String tableName) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "UPDATE " + tableName + " SET answer = '" + obj.getAnswer()+ "', status = 'finish' WHERE id = '" + obj.getId() + "'";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (Exception se) {

            se.printStackTrace();
        }

        return false;
    }
}
