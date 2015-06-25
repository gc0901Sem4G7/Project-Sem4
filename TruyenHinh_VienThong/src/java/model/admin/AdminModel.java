package model.admin;

import java.sql.*;

import common.Common;
import doituong.User;

public class AdminModel {

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;

    public boolean insert(User user, String tableName) {
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

            String sql = "INSERT INTO  " + tableName + " (username, password, name, card_id, phone_number, email, address, package_id, dealer_id) "
                    + " VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getCardId() + "', '" + user.getPhoneNumber() + "', '" + user.getEmail() + "', '" + user.getAddress() + "', '" + user.getPackageId() + "', '" + user.getDealerId() + "')";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
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

    public String checkLoginAdmin(String username, String password) {
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

            String sql = "Select * From dealer";

            ResultSet resultSet = stmt.executeQuery(sql);
            String bac = "bac";
            String trung = "trung";
            String nam = "nam";
            String admin = "admin";
            while (resultSet.next()) {
                if (username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password"))) {
                    if (bac.equals(resultSet.getString("mien"))) {
                        return bac;
                    } else if (trung.equals(resultSet.getString("mien"))) {
                        return trung;
                    } else if (nam.equals(resultSet.getString("mien"))) {
                        return nam;
                    } else if (admin.equals(resultSet.getString("mien"))) {
                        return admin;
                    }
                }
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
        return "";
    }
}
