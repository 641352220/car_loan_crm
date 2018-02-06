package com.bootdo.common.utils.insertBatch;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 *  合肥工业大学 管理学院 qianyang 1563178220@qq.com
 */
public class MySQLConnections {


    private String driver = "";
    private String dbURL = "";
    private String user = "";
    private String password = "";
    private static MySQLConnections connection = null;

    private MySQLConnections() throws Exception {
        driver = "com.mysql.jdbc.Driver";
        dbURL = "jdbc:mysql://127.0.0.1:3306/db_car_loan";
        user = "root";
        password = "";
    }

    public static Connection getConnection() {
        Connection conn = null;
        if (connection == null) {
            try {
                connection = new MySQLConnections();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        try {
            Class.forName(connection.driver);
            conn = DriverManager.getConnection(connection.dbURL,
                    connection.user, connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
