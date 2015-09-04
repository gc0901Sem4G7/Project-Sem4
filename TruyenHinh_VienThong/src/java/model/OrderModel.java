
package model;

import common.Common;
import doituong.DichVu;
import doituong.Order;
import doituong.OrderByTenDichVu;
import doituong.OrderByTrangThai;
import doituong.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderModel {
    
    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;
    
    public List<Order> getAllOrderByMien(String tableName, String mien) {
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

        String sql = "Select * From `" + tableName + "` Where mien = '" + mien + "'";

        if (mien.equals("null")) {
          sql = "Select * From `" + tableName;
        }
        System.out.println(sql);
        ResultSet resultSetOrder = stmt.executeQuery(sql);


        Order orderObject;

        while (resultSetOrder.next()) {
          orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("dia_chi_nap_dat"), resultSetOrder.getInt("thoi_luong"), resultSetOrder.getString("gia_tien"),resultSetOrder.getString("status"), resultSetOrder.getDate("date_register"), resultSetOrder.getDate("date_begin"), resultSetOrder.getDate("date_end"));
          orderObject.setHinhThucThanhToan(resultSetOrder.getString("hinh_thuc_thanh_toan"));
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
    
    public List<Order> getAllOrderByMien(String tableName, String mien, String trangThai, String thoiGian) {
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

        String sql = "Select * From `" + tableName + "` Where mien = '" + mien + "'";

        if (trangThai != null) {
          if (!"".equals(trangThai)) {
            sql += " And status = '" + trangThai + "'";
          }
        }
        if (thoiGian != null) {
          if (!"".equals(thoiGian)) {
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            sql += " And date_register Between '" + year + "-" + thoiGian + "-" + "01' And '" + year + "-" + thoiGian + "-" + "31" + "'";
          }
        }
        
        if (mien.equals("null")) {
          sql = "Select * From `" + tableName;
        }
        System.out.println(sql);
        ResultSet resultSetOrder = stmt.executeQuery(sql);


        Order orderObject;

        while (resultSetOrder.next()) {
          orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("dia_chi_nap_dat"), resultSetOrder.getInt("thoi_luong"), resultSetOrder.getString("gia_tien"),resultSetOrder.getString("status"), resultSetOrder.getDate("date_register"), resultSetOrder.getDate("date_begin"), resultSetOrder.getDate("date_end"));
          orderObject.setHinhThucThanhToan(resultSetOrder.getString("hinh_thuc_thanh_toan"));
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
    
    public List<OrderByTrangThai> getAllOrderByMien(String mien) {
      Connection conn = null;
      Statement stmt = null;
      List<OrderByTrangThai> listOrderByTrangThai = new ArrayList<OrderByTrangThai>();
      try {
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        System.out.println("Connected database successfully...");

        //STEP 4: Execute a query
        stmt = conn.createStatement();

        String sql = "Select * From `order` Where mien = '" + mien + "'";
        sql += " And status != 'Da huy'";

        System.out.println(sql);
        ResultSet resultSet = stmt.executeQuery(sql);


        OrderByTrangThai obj;

        while (resultSet.next()) {
          String username = resultSet.getString("username");

          String email = new UserModel().getUserByUsername("user", username).getEmail();

          obj = new OrderByTrangThai(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("ten_dich_vu"), resultSet.getDate("date_register") + "", resultSet.getDate("date_end")  + "",  email);

          listOrderByTrangThai.add(obj);
        }

        return listOrderByTrangThai;

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
    
    public List<OrderByTrangThai> getAllOrderByMien(String mien, String trangThai, String thoiGian) {
      Connection conn = null;
      Statement stmt = null;
      List<OrderByTrangThai> listOrderByTrangThai = new ArrayList<OrderByTrangThai>();
      try {
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        System.out.println("Connected database successfully...");

        //STEP 4: Execute a query
        stmt = conn.createStatement();

        String sql = "Select * From `order` Where mien = '" + mien + "'";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = dateFormat.format(new Date());
        
        if (trangThai != null) {
          if (!"".equals(trangThai)) {
            if (trangThai.equals("saphethan")) {
              sql += " And ( (Substring(date_end, 1,4) = '" + dateNow.substring(0,4) + "' And Substring(date_end, 6,2) = '" + dateNow.substring(5,7) + "' And Substring(date_end, 9,2) >= '" + dateNow.substring(8,10) + "') Or (Substring(date_end, 1,4) = '" + (Integer.parseInt(dateNow.substring(0,4)) + 1) + "' And Substring(date_end, 6,2) = '01' And MONTH(now()) = '12' ) And Substring(date_end, 9,2) <= DAY(now()))";
//              sql += " And ( (Substring(date_end, 1,4) = '" + dateNow.substring(0,4) + "' And Substring(date_end, 6,2) = '" + dateNow.substring(5,7) + "' And Substring(date_end, 9,2) >= '" + dateNow.substring(8,10) + "' ) Or ( Substring(date_end, 1,4) = '" + (Integer.parseInt(dateNow.substring(0,4)) + 1) + "' And Substring(date_end, 6,2) = '01' And MONTH(getdate()) = '12' And Substring(date_end, 8,2) <= DAY(getdate()) ) )";
            } else if (trangThai.equals("hethan")) {
              sql += " And ( Substring(date_end, 1,4) < '" + dateNow.substring(0,4) + "' Or (Substring(date_end, 1,4) = '" + dateNow.substring(0,4) + "' And Substring(date_end, 6,2) < '" + dateNow.substring(5,7) + "' ) Or (Substring(date_end, 1,4) = '" + dateNow.substring(0,4) + "' And Substring(date_end, 6,2) = '" + dateNow.substring(5,7) + "' And Substring(date_end, 9,2) < '" + dateNow.substring(8,10) + "' ) )";
//              sql += " And (Substring(date_end, 1,4) = '" + dateNow.substring(0,4) + "' And (Substring(date_end, 6,2) < '" + dateNow.substring(5,7) + "' Or (Substring(date_end, 6,2) = '" + dateNow.substring(5,7) + "' And Substring(date_end, 9,2) > '" + dateNow.substring(8,10) + "' ) )"
//                      + "Or (Substring(date_end, 1,4) < '" + (Integer.parseInt(dateNow.substring(0,4)) + 1) + "'";
              
            } else if (trangThai.equals("dangsudung")) {
              sql += " And ( (Substring(date_end, 1,4) = '" + dateNow.substring(0,4) + "' And Substring(date_end, 6,2) > '" + dateNow.substring(5,7) + "' And Substring(date_end, 9,2) > '" + dateNow.substring(8,10) + "') Or (Substring(date_end, 1,4) >= '" + (Integer.parseInt(dateNow.substring(0,4)) + 2) + "') Or (Substring(date_end, 1,4) = '" + (Integer.parseInt(dateNow.substring(0,4)) + 1) + "' And Substring(date_end, 9,2) < DAY(now()))";
            }
            
          }
        }
        if (thoiGian != null) {
          if (!"".equals(thoiGian)) {
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            sql += " And date_register Between '" + year + "-" + thoiGian + "-" + "01' And '" + year + "-" + thoiGian + "-" + "31" + "'";
          }
        }
        
        if (mien.equals("null")) {
          sql = "Select * From order";
        }
        
        sql += " And status != 'Da huy' ";
        
        System.out.println(sql);
        ResultSet resultSet = stmt.executeQuery(sql);


        OrderByTrangThai obj;

        while (resultSet.next()) {
          String username = resultSet.getString("username");

          String email = new UserModel().getUserByUsername("user", username).getEmail();

          obj = new OrderByTrangThai(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("ten_dich_vu"), resultSet.getDate("date_register") + "", resultSet.getDate("date_end")  + "",  email);

          listOrderByTrangThai.add(obj);
        }

        return listOrderByTrangThai;

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
    
    public List<Order> getListOrderByListUsername(String tableName, List<String> listUsername) {
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
                orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("dia_chi_nap_dat"), resultSetOrder.getInt("thoi_luong"), resultSetOrder.getString("gia_tien"),resultSetOrder.getString("status"), resultSetOrder.getDate("date_register"), resultSetOrder.getDate("date_begin"), resultSetOrder.getDate("date_end"));
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
    
    public List<OrderByTenDichVu> getListOrderByTenDichVu(String TenDichVu) {
      Connection conn = null;
      Statement stmt = null;
      List<OrderByTenDichVu> listOrderByTenDichVu = new ArrayList<OrderByTenDichVu>();
      try {
        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        stmt = conn.createStatement();

        String sql = "";
        sql = "Select * ";
        sql += " From `order` as o, `dich_vu` as d ";
        sql += " Where o.ten_dich_vu = d.ten_dich_vu";
        sql += " and o.ten_dich_vu = '" + TenDichVu + "' ";

        System.out.println(sql);
        ResultSet resultSet = stmt.executeQuery(sql);

        OrderByTenDichVu obj;

        while (resultSet.next()) {
          obj = new OrderByTenDichVu();
          
          obj.setUsername(resultSet.getString("username"));
          obj.setTenDichVu(resultSet.getString("ten_dich_vu"));
          obj.setThoiLuong(resultSet.getInt("thoi_luong"));
          obj.setGiaDichVu(resultSet.getString("gia"));
          obj.setThanhTien(resultSet.getString("gia_tien"));
          obj.setDiaChiNapDat(resultSet.getString("dia_chi_nap_dat"));
          obj.setMoTa(resultSet.getString("mo_ta"));
          obj.setTrangThai(resultSet.getString("status"));
          obj.setDateBegin(resultSet.getDate("date_register"));
          obj.setDateEnd(resultSet.getDate("date_end"));
          
          if (resultSet.getString("hinh_thuc_thanh_toan") != null) {
            obj.setHinhThucThanhToan(resultSet.getString("hinh_thuc_thanh_toan"));
          }
          
          listOrderByTenDichVu.add(obj);
        }

        return listOrderByTenDichVu;

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
    
    public List<String> getListUsernameInOrderDistinct(String tableName) {
        Connection conn = null;
        Statement stmt = null;
        List<String> listUsernameInOrderDistinct = new ArrayList<String>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "Select Distinct username From `" + tableName + "`";

            System.out.println(sql);
            ResultSet resultSetOrder = stmt.executeQuery(sql);

            
            Order orderObject;

            while (resultSetOrder.next()) {
                listUsernameInOrderDistinct.add(resultSetOrder.getString("username"));
            }

            return listUsernameInOrderDistinct;

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
        return listUsernameInOrderDistinct;
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
            
            String sql = "Select * From `" + tableName + "` WHERE username = '" + username + "' And status != 'Da huy'";

            ResultSet resultSetOrder = stmt.executeQuery(sql);
            
            Order orderObject;

            while (resultSetOrder.next()) {
                orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("dia_chi_nap_dat"), resultSetOrder.getInt("thoi_luong"), resultSetOrder.getString("gia_tien"), resultSetOrder.getString("status"), resultSetOrder.getDate("date_register"), resultSetOrder.getDate("date_begin"), resultSetOrder.getDate("date_end"));
                if (resultSetOrder.getString("hinh_thuc_thanh_toan") != null) {
                  orderObject.setHinhThucThanhToan(resultSetOrder.getString("hinh_thuc_thanh_toan"));
                }
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
                orderObject = new Order(resultSetOrder.getInt("id"), resultSetOrder.getString("username"), resultSetOrder.getString("ten_dich_vu"), resultSetOrder.getString("mien"), resultSetOrder.getString("status"), resultSetOrder.getDate("date_end"), "date", resultSetOrder.getString("hinh_thuc_thanh_toan"), resultSetOrder.getString("dia_chi_nap_dat"), resultSetOrder.getInt("thoi_luong"), resultSetOrder.getString("gia_tien"), resultSetOrder.getDate("date_register"));
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
    
    public boolean insert(DichVu objDichVu, User objUser, String mien, String tableName, String dateRegister, String diaChiNapDat, int thoiLuong, String dateEnd, String hinhThucThanhToan) {
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
            
            String sql = "INSERT INTO  `" + tableName + "` (username, ten_dich_vu, mien, status, date_register, dia_chi_nap_dat, thoi_luong, gia_tien, date_end, hinh_thuc_thanh_toan) " + " VALUES ('" + objUser.getUsername() + "', '" + objDichVu.getTenDichVu() + "','" + mien + "', 'waiting', '" + dateRegister + "', '" + diaChiNapDat + "', '" + thoiLuong + "', '" + Integer.parseInt(objDichVu.getGiaDichVu())  + "', '" + dateEnd + "', '" + hinhThucThanhToan + "')";
            
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
    
    public boolean update(Order obj, String tableName, String dateRegister, String dateEnd) {
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

        String sql = "UPDATE `" + tableName + "` SET date_register = '" + dateRegister + "', date_end = '" + dateEnd + "'" + " WHERE id = '" + obj.getId() + "'";
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
