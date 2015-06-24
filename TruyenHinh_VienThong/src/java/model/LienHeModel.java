package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.Common;
import doituong.LienHe;

public class LienHeModel {

    public static final String JDBC_DRIVER = Common.JDBC_DRIVER;
    public static final String DB_URL = Common.DB_URL;
    public static final String USERNAME = Common.USERNAME;
    public static final String PASSWORD = Common.PASSWORD;

    public LienHe getInfoLienHe() {
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

            String sql = "Select * From lien_he";

            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);

            List<LienHe> list = new ArrayList<LienHe>();
            LienHe obj;

            while (resultSet.next()) {
                obj = new LienHe(resultSet.getInt("id"), resultSet.getString("dia_chi"), resultSet.getString("dien_thoai"), resultSet.getString("ten_cong_ty"), resultSet.getString("email"), resultSet.getString("skype"));
                list.add(obj);
            }

            return list.get(0);

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
