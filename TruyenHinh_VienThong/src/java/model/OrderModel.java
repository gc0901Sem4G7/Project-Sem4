
package model;

import common.Common;
import doituong.DichVu;
import doituong.Order;
import doituong.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModel {
    
    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;
    
    public List<Order> getAllOrder(String tableName) {
        Connection conn = null;
        Statement stmt = null;
        List<Order> listOrder = new ArrayList<Order>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From `" + tableName + "`";

            System.out.println(sql);
            ResultSet resultSetOrder = stmt.executeQuery(sql);

            
            Order orderObject;

            while (resultSetOrder.next()) {
                orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("status"));
                listOrder.add(orderObject);
            }

            return listOrder;

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
        return listOrder;
    }
    
    public List<Order> getListOrderByMien(String tableName, String mien) {
        Connection conn = null;
        Statement stmt = null;
        List<Order> listOrder = new ArrayList<Order>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            
            String sql = "Select * From `" + tableName + "` WHERE mien = '" + mien + "'";
            
            if (mien.equals("admin")) {
                sql = "Select * From `" + tableName + "`";
            }

            ResultSet resultSetOrder = stmt.executeQuery(sql);

            
            Order orderObject;

            while (resultSetOrder.next()) {
                orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("status"));
                listOrder.add(orderObject);
            }

            return listOrder;

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
        return listOrder;
    }
    
    public List<Order> getListOrderByUsername(String tableName, String username) {
        Connection conn = null;
        Statement stmt = null;
        List<Order> listOrder = new ArrayList<Order>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            
            String sql = "Select * From `" + tableName + "` WHERE username = '" + username + "'";

            ResultSet resultSetOrder = stmt.executeQuery(sql);
            
            Order orderObject;

            while (resultSetOrder.next()) {
                orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("status"));
                listOrder.add(orderObject);
            }

            return listOrder;

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
        return listOrder;
    }
    
    public Order getOrderById(String tableName, int id) {
        Connection conn = null;
        Statement stmt = null;
        Order orderObject = new Order();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            
            String sql = "Select * From `" + tableName + "` WHERE id = '" + id + "'";
            
            ResultSet resultSetOrder = stmt.executeQuery(sql);
            
            

            while (resultSetOrder.next()) {
                orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("status"));
            }

            return orderObject;

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
        return orderObject;
    }
    
    public boolean insert(DichVu objDichVu, User objUser, String mien, String tableName, Date dateRegister) {
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

            String sql = "INSERT INTO  `" + tableName + "` (username, ten_dich_vu, mien, status, date_register) " + " VALUES ('" + objUser.getUsername() + "', '" + objDichVu.getTenDichVu() + "','" + mien + "', 'waiting', '2015-06-05')";
            
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (Exception se) {

            se.printStackTrace();
        }

        return false;
    }
    
    public boolean update(Order obj, String tableName) {
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

            String sql = "UPDATE `" + tableName + "` SET username = '" + obj.getUsername()+ "', ten_dich_vu = '" + obj.getTenDichVu()+ "', mien = '" + obj.getMien() + "', status = '" + obj.getStatus() + "' WHERE id = '" + obj.getId() + "'";
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
