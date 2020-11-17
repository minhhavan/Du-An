/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienich;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SuongNguyen
 */
public class JDBCHelper {
    
    private static Connection con;
    private static final String USER = "sa";
    private static final String PASSWORD = "123";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CONNECTION = "jdbc:sqlserver://localhost:1433;databasename=MMFastFood";
    
    public static void openConnect() throws SQLException, ClassNotFoundException{
        Class.forName(DRIVER);
        con = DriverManager.getConnection(CONNECTION,USER,PASSWORD);
    }
    
    private static PreparedStatement getSQLStatement(String sql) throws SQLException {
        if (sql.startsWith("{")) {
            return con.prepareCall(sql);
        } 
        return con.prepareStatement(sql);
    }
    
    private static void addParameter(PreparedStatement sql, Object...x) throws SQLException {
        for (int i = 0; i < x.length; i++) {
            sql.setObject(i+1, x[i]);
        }
    } 
    
    private static PreparedStatement getPreparedStatement(String sql, Object...x) throws SQLException {
        PreparedStatement preparestatement = getSQLStatement(sql);
        addParameter(preparestatement, x);
        return preparestatement;
    }
    
    public static ResultSet queryResult(String sql, Object...x) throws SQLException {
        return getPreparedStatement(sql, x).executeQuery();
    }
    
    public static int update(String sql, Object...x) throws SQLException {
        int row = getPreparedStatement(sql, x).executeUpdate();
        return row;
    }
}
