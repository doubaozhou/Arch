package com.arch.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by zhou on 2016/5/20.
 * @author zhou
 */
public class ConnectionFactory {
    private static String driver;
    private static String dburl;
    private static String user;
    private static String pwd;
    private static Connection conn = null;

    private static final ConnectionFactory factory = new ConnectionFactory();

    static {
        Properties prop = new Properties();
        try {
            InputStream in =  ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            prop.load(in);
        } catch (Exception e) {
            System.out.println("read property file error !");
            e.printStackTrace();
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        pwd = prop.getProperty("password");
    }

    private ConnectionFactory() {

    }

    public static ConnectionFactory getInstance() {
        return factory;
    }

    public static Connection getConnection() {
        if (conn == null) {
            return makeConnection();
        } else {
            return conn;
        }
    }

    public static Connection makeConnection() {
        try {
            Class.forName(driver);
//            String url = dburl + "?user=" + user +"&password=" + pwd + "&useUnicode=true&characterEncoding=UTF8";
            conn = DriverManager.getConnection(dburl, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
