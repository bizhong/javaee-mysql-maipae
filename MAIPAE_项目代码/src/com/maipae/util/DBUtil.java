package com.maipae.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    
    public static String driver = "com.mysql.jdbc.Driver";
    
    public static String url = "jdbc:mysql://localhost:3306/maipae?useUnicode=true&characterEncoding=utf-8";
    
    public static String username = "root";
    
    public static String password = "123456";
    
    private Connection conn;
    
    private PreparedStatement pats;
    
    private ResultSet rs;
    
    public ResultSet getRs() {
        return rs;
    }
    
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public PreparedStatement getPats() {
        return pats;
    }
    
    public void setPats(PreparedStatement pats) {
        this.pats = pats;
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    /*
     * 数据库链接
     */
    public void ConnDB() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public DBUtil() {
        try {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public boolean InsertUpdateDeleteExcute(String sql, List<Object> param) {
        boolean flag = false;
        try {
            // 获取数据库连接
            this.ConnDB();
            pats = conn.prepareStatement(sql);
            pats.clearParameters();
            if (null != param && param.size() > 0) {
                for (int i = 0; i < param.size(); i++) {
                    pats.setObject(i + 1, param.get(i));
                }
            }
            int ex = pats.executeUpdate();
            flag = ex > 0 ? true : false;
            
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                pats.close();
                conn.close();
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        return flag;
        
    }
    
    public <T> List<T> queryInfoByParam(String sql,
                                        List<Object> param,
                                        Class<T> zlass) throws InstantiationException,
                                                       IllegalAccessException,
                                                       NoSuchFieldException,
                                                       SecurityException {
        List<T> list = new ArrayList<T>();
        try {
            // 获取数据库连接
            this.ConnDB();
            // 得到参数执行方法
            pats = conn.prepareStatement(sql);
            // 清空参数值
            pats.clearParameters();
            
            if (null != param && param.size() > 0) {
                for (int i = 0; i < param.size(); i++) {
                    pats.setObject(i + 1, param.get(i));
                }
            }
            
            rs = pats.executeQuery();
            
            ResultSetMetaData meteData = rs.getMetaData();// 得到源数据
            int columcount = meteData.getColumnCount(); // 得到总列数
            
            while (rs.next()) {
                // 通过反射机制创建我们的实例
                T t = zlass.newInstance();// new userEntiy
                for (int i = 0; i < columcount; i++) {
                    String columnName = meteData.getColumnName(i + 1);
                    Object columnValue = rs.getObject(columnName);
//                    if (null == columnValue) {
//                        columnValue = "";
//                    }
                    Field field = zlass.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                pats.close();
                conn.close();
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        return list;
    }
}
