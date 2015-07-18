package model.admin;

import java.sql.*;

import common.Common;
import doituong.Dealer;
import doituong.DichVu;
import java.util.ArrayList;
import java.util.List;
import static model.DichVuModel.DB_URL;
import static model.DichVuModel.JDBC_DRIVER;
import static model.DichVuModel.PASSWORD;
import static model.DichVuModel.USERNAME;

public class AdminDealerModel{

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;

    public List<Dealer> getAllListDealer() {
        Connection conn = null;
        Statement stmt = null;
        List<Dealer> listDealer = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From dealer";

            ResultSet resultSet = stmt.executeQuery(sql);
            Dealer dealer = new Dealer();
            
            while (resultSet.next()) {
                dealer = new Dealer(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("name"), resultSet.getString("sex"), resultSet.getString("email"), resultSet.getString("phone"), resultSet.getString("address"), resultSet.getString("mien"));
                listDealer.add(dealer);
            }
            return listDealer;

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
    
    public Dealer getDealerById(int id) {
        Connection conn = null;
        Statement stmt = null;
        Dealer dealerObject = new Dealer();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From dealer WHERE id = " + id;

            System.out.println(sql);
            ResultSet resultSetDichVu = stmt.executeQuery(sql);

            while (resultSetDichVu.next()) {
                dealerObject = new Dealer(resultSetDichVu.getInt("id"), resultSetDichVu.getString("username"), resultSetDichVu.getString("password"), resultSetDichVu.getString("name"), resultSetDichVu.getString("sex"), resultSetDichVu.getString("email"), resultSetDichVu.getString("phone"), resultSetDichVu.getString("address"), resultSetDichVu.getString("mien"));
            }

            return dealerObject;

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
    
    public Dealer getDealerByUsername(String username) {
        Connection conn = null;
        Statement stmt = null;
        List<DichVu> listDealer = new ArrayList<DichVu>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From dealer WHERE username = '" + username + "'";

            System.out.println(sql);
            ResultSet resultSetDichVu = stmt.executeQuery(sql);

            
            Dealer dealerObject = new Dealer();

            while (resultSetDichVu.next()) {
                dealerObject = new Dealer(resultSetDichVu.getInt("id"), resultSetDichVu.getString("username"), resultSetDichVu.getString("password"), resultSetDichVu.getString("name"), resultSetDichVu.getString("sex"), resultSetDichVu.getString("email"), resultSetDichVu.getString("phone"), resultSetDichVu.getString("address"), resultSetDichVu.getString("mien"));
            }

            return dealerObject;

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

    public boolean insertDealer(Dealer obj, String tableName) {
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

            String sql = "INSERT INTO " + tableName + " (username, password, name, sex, email, phone, address, mien) " + " VALUES ('" + obj.getUsername() + "', '" + obj.getPassword() + "','" + obj.getName() + "', '" + obj.getSex()+ "', '" + obj.getEmail() + "', '" + obj.getPhone() + "', '" + obj.getAddress()+ "', '" + obj.getMien() + "')";
            
            stmt.execute(sql);

            return true;
        } catch (Exception se) {

            se.printStackTrace();
        }

        return false;
    }
    
    public boolean deleteDealer(int id, String tableName) {
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

            String sql = "DELETE FROM  " + tableName + " WHERE id = '" + id + "'";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (Exception se) {

            se.printStackTrace();
        }
        return false;
    }
    
    public boolean updateDealer(String tableName, Dealer dealer) {
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

            String sql =    " UPDATE " + tableName +
                            " SET " + 
                                " username = '" + dealer.getUsername() + "' , " +
                                " password = '" + dealer.getPassword() + "' , " +
                                " name = '" + dealer.getName() + "' , " +
                                " name = '" + dealer.getName() + "' , " +
                                " sex = '" + dealer.getSex() + "' , " +
                                " email = '" + dealer.getEmail() + "' , " +
                                " phone = '" + dealer.getPhone() + "' , " +
                                " address = '" + dealer.getAddress() + "' , " +
                                " mien = '" + dealer.getMien() + "' " +
                            " WHERE id = '" + dealer.getId() + "'";
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
