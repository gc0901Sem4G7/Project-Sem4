package model;

import java.sql.*;

import common.Common;
import doituong.Dealer;
import doituong.User;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;

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
    
    public List<User> getAllListUser() {
        Connection conn = null;
        Statement stmt = null;
        List<User> listUser = new ArrayList<>();
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

            ResultSet resultSetUsers = stmt.executeQuery(sql);
            User user = new User();
            
            while (resultSetUsers.next()) {
                user = new User(resultSetUsers.getInt("id"), resultSetUsers.getString("username"), resultSetUsers.getString("password"), resultSetUsers.getString("name"), resultSetUsers.getString("card_id"), resultSetUsers.getString("phone_number"), resultSetUsers.getString("email"), resultSetUsers.getString("address"), resultSetUsers.getInt("package_id"), resultSetUsers.getInt("dealer_id"));
                listUser.add(user);
            }
            return listUser;

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
    
    public List<User> getAllListUserByMienOfAdmin(String mien) {
        Connection conn = null;
        Statement stmt = null;
        List<User> listUser = new ArrayList<>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From user Where mien = '" + mien + "'";

            ResultSet resultSetUsers = stmt.executeQuery(sql);
            User user = new User();
            
            while (resultSetUsers.next()) {
                user = new User(resultSetUsers.getInt("id"), resultSetUsers.getString("username"), resultSetUsers.getString("password"), resultSetUsers.getString("name"), resultSetUsers.getString("card_id"), resultSetUsers.getString("phone_number"), resultSetUsers.getString("email"), resultSetUsers.getString("address"), resultSetUsers.getInt("package_id"), resultSetUsers.getInt("dealer_id"));
                listUser.add(user);
            }
            return listUser;

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
    
    public User getUserByUsername(String tableName, String username) {
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

            String sql = "Select * From user Where username = '" + username + "' ";

            ResultSet resultSet = stmt.executeQuery(sql);
            
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("name"), resultSet.getString("card_id"), resultSet.getString("phone_number"), resultSet.getString("email"), resultSet.getString("address"), resultSet.getInt("package_id"), resultSet.getInt("dealer_id"));
            }
            return user;

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
    
    public String getMienOfDealerByUsername(String tableName, String username) {
        Connection conn = null;
        Statement stmt = null;
        
        List<Dealer> listDealer = new ArrayList<Dealer>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From " + tableName + " WHERE username = '" + username + "'";

            ResultSet resultSetDealer = stmt.executeQuery(sql);

            
            Dealer dealerObject;

            while (resultSetDealer.next()) {
                dealerObject = new Dealer();
                dealerObject.setMien(resultSetDealer.getString("mien"));
                listDealer.add(dealerObject);
            }

            return listDealer.get(0).getMien();

        } catch (Exception se) {

            se.printStackTrace();
        }
        return null;
    }
    
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

            String sql = "INSERT INTO `" + tableName + "` (username, password, name, card_id, phone_number, email, address, package_id, dealer_id) "
                    + " VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getCardId() + "', '" + user.getPhoneNumber() + "', '" + user.getEmail() + "', '" + user.getAddress() + "', '" + user.getPackageId() + "', '" + user.getDealerId() + "')";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (SQLException se) {
            System.out.println(se);
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
    
    public boolean insertUser(User user, String tableName) {
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

            String sql = "INSERT INTO `" + tableName + "` (username, password, name, card_id, phone_number, email, address, package_id, dealer_id, mien) "
                    + " VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getCardId() + "', '" + user.getPhoneNumber() + "', '" + user.getEmail() + "', '" + user.getAddress() + "', '" + user.getPackageId() + "', '" + user.getDealerId() + "', '" + user.getMien() + "')";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (SQLException se) {
            System.out.println(se);
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

    public boolean checkLoginUser(String username, String password) {
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

            while (users.next()) {
                if (username.equals(users.getString("username")) && password.equals(users.getString("password"))) {
                    return true;
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
        return false;
    }
}
