package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.Common;
import doituong.DichVu;
import static model.admin.AdminDichVuModel.DB_URL;
import static model.admin.AdminDichVuModel.JDBC_DRIVER;
import static model.admin.AdminDichVuModel.PASSWORD;
import static model.admin.AdminDichVuModel.USERNAME;

public class DichVuModel {

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;

    public List<DichVu> getAllDichVu(String tableName) {
        Connection conn = null;
        Statement stmt = null;
        List<DichVu> listDichVu = new ArrayList<DichVu>();
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
            ResultSet resultSetDichVu = stmt.executeQuery(sql);

            
            DichVu dichVuObject;

            while (resultSetDichVu.next()) {
                dichVuObject = new DichVu(resultSetDichVu.getInt("id"), resultSetDichVu.getString("ten_dich_vu"), resultSetDichVu.getString("gia"), resultSetDichVu.getString("mo_ta"), resultSetDichVu.getInt("dealer_id"), resultSetDichVu.getString("trang_thai"));
                listDichVu.add(dichVuObject);
            }

            return listDichVu;

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
        return listDichVu;
    }

    public DichVu getDichVuById(int id,String tableName) {
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

            String sql = "Select * From " + tableName + " WHERE id = " + id;

            System.out.println(sql);
            ResultSet resultSetDichVu = stmt.executeQuery(sql);

            List<DichVu> listDichVu = new ArrayList<DichVu>();
            DichVu dichVuObject;

            while (resultSetDichVu.next()) {
                dichVuObject = new DichVu(resultSetDichVu.getInt("id"), resultSetDichVu.getString("ten_dich_vu"), resultSetDichVu.getString("gia"), resultSetDichVu.getString("mo_ta"), resultSetDichVu.getInt("dealer_id"), resultSetDichVu.getString("trang_thai"));
                listDichVu.add(dichVuObject);
            }

            return listDichVu.get(0);

        } catch (Exception se) {

            se.printStackTrace();
        }
        return null;
    }
    
    public List<DichVu> getDichVuAccepted(String tableName) {
        Connection conn = null;
        Statement stmt = null;
        List<DichVu> listDichVu = new ArrayList<DichVu>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From " + tableName + " WHERE trang_thai = 'accepted'";

            System.out.println(sql);
            ResultSet resultSetDichVu = stmt.executeQuery(sql);

            
            DichVu dichVuObject;

            while (resultSetDichVu.next()) {
                dichVuObject = new DichVu(resultSetDichVu.getInt("id"), resultSetDichVu.getString("ten_dich_vu"), resultSetDichVu.getString("gia"), resultSetDichVu.getString("mo_ta"), resultSetDichVu.getInt("dealer_id"), resultSetDichVu.getString("trang_thai"));
                listDichVu.add(dichVuObject);
            }

            return listDichVu;

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
        return listDichVu;
    }
    
    public List<DichVu> getListDichVuByVung(String tableName, String vung) {
        Connection conn = null;
        Statement stmt = null;
        List<DichVu> listDichVu = new ArrayList<DichVu>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From " + tableName + " WHERE vung LIKE '%" + vung + "%'";

            System.out.println(sql);
            ResultSet resultSetDichVu = stmt.executeQuery(sql);

            
            DichVu dichVuObject;

            while (resultSetDichVu.next()) {
                dichVuObject = new DichVu(resultSetDichVu.getInt("id"), resultSetDichVu.getString("ten_dich_vu"), resultSetDichVu.getString("gia"), resultSetDichVu.getString("mo_ta"), resultSetDichVu.getInt("dealer_id"), resultSetDichVu.getString("trang_thai"));
                listDichVu.add(dichVuObject);
            }

            return listDichVu;

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
        return listDichVu;
    }
    public List<DichVu> getListDichVuByVungAndAccept(String tableName, String vung) {
        Connection conn = null;
        Statement stmt = null;
        List<DichVu> listDichVu = new ArrayList<DichVu>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select * From " + tableName + " WHERE trang_thai = 'accepted' and vung LIKE '%" + vung + "%'";

            System.out.println(sql);
            ResultSet resultSetDichVu = stmt.executeQuery(sql);

            
            DichVu dichVuObject;

            while (resultSetDichVu.next()) {
                dichVuObject = new DichVu(resultSetDichVu.getInt("id"), resultSetDichVu.getString("ten_dich_vu"), resultSetDichVu.getString("gia"), resultSetDichVu.getString("mo_ta"), resultSetDichVu.getInt("dealer_id"), resultSetDichVu.getString("trang_thai"));
                listDichVu.add(dichVuObject);
            }

            return listDichVu;

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
        return listDichVu;
    }
    
    public boolean insert(DichVu obj, String tableName) {
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

            String sql = "INSERT INTO  " + tableName + " (ten_dich_vu, gia, mo_ta, dealer_id, trang_thai, vung) " + " VALUES ('" + obj.getTenDichVu() + "', '" + obj.getGiaDichVu() + "','" + obj.getMoTa() + "', '" + obj.getDealerId()+ "', '" + obj.getTrangThai() + "', '" + obj.getMien()+ "')";
            
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (Exception se) {

            se.printStackTrace();
        }

        return false;
    }

    public boolean update(DichVu obj, String tableName) {
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

            String sql = "UPDATE " + tableName + " SET ten_dich_vu = '" + obj.getTenDichVu() + "', gia = '" + obj.getGiaDichVu()+ "', mo_ta = '" + obj.getMoTa() + "', dealer_id = '" + obj.getDealerId()+ "', trang_thai = '" + obj.getTrangThai()+ "' WHERE id = '" + obj.getId() + "'";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Inserted records into the table...");

            return true;
        } catch (Exception se) {

            se.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id, String tableName) {
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
}
