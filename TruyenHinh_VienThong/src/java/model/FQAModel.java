package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Common;
import doituong.DichVu;
import doituong.FQA;
import doituong.User;
import java.util.ArrayList;
import java.util.List;
import static model.DichVuModel.DB_URL;
import static model.DichVuModel.JDBC_DRIVER;
import static model.DichVuModel.PASSWORD;
import static model.DichVuModel.USERNAME;


public class FQAModel {

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;

    public User getUserByUsername(String username) {
        Connection conn = null;
        Statement stmt = null;
        User user = new User();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From user Where username = '" + username + "'";

            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                user = new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("name"), resultSet.getString("card_id"), resultSet.getString("phone_number"), resultSet.getString("email"), resultSet.getString("adress"), resultSet.getInt("package_id"), resultSet.getInt("dealer_id"));
                
            }

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
        return user;
    }
    
    public boolean insert(FQA obj, String tableName) {
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

            String sql = "INSERT INTO  " + tableName + " (question, answer, username, status) " + " VALUES ('" + obj.getQuestion()+ "', '" + obj.getAnswer()+ "','" + obj.getUsername() + "', '" + obj.getStatus() + "')";
            
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (Exception se) {

            se.printStackTrace();
        }

        return false;
    }
    
    public ResultSet getAllUser() {
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
            stmt = conn.createStatement();

            String sql = "Select * From user";

            ResultSet users = stmt.executeQuery(sql);

            return users;

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
        return null;
    }
    
    public List<FQA> getAllFQA(String tableName) {
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

            String sql = "Select * From " + tableName;

            System.out.println(sql);
            ResultSet resultSetFQA = stmt.executeQuery(sql);

            
            FQA fqaObject;

            while (resultSetFQA.next()) {
                fqaObject = new FQA(resultSetFQA.getInt("id"), resultSetFQA.getString("question"), resultSetFQA.getString("answer"), resultSetFQA.getString("username"), resultSetFQA.getString("status"));
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
    
    public List<FQA> getAllFQAFinish(String tableName) {
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

            String sql = "Select * From " + tableName + " WHERE status = 'finish'";

            System.out.println(sql);
            ResultSet resultSetFQA = stmt.executeQuery(sql);

            
            FQA fqaObject;

            while (resultSetFQA.next()) {
                fqaObject = new FQA(resultSetFQA.getInt("id"), resultSetFQA.getString("question"), resultSetFQA.getString("answer"), resultSetFQA.getString("username"), resultSetFQA.getString("status"));
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
    
    public FQA getFQAById(String tableName, int id) {
        Connection conn = null;
        Statement stmt = null;
        FQA fqa = new FQA();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From " + tableName + " WHERE id = '" + id + "'";

            System.out.println(sql);
            ResultSet resultSetFQA = stmt.executeQuery(sql);

            
            FQA fqaObject;

            while (resultSetFQA.next()) {
                fqaObject = new FQA(resultSetFQA.getInt("id"), resultSetFQA.getString("question"), resultSetFQA.getString("answer"), resultSetFQA.getString("username"), resultSetFQA.getString("status"));
            }

            return fqa;

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
        return null;
    }
}
