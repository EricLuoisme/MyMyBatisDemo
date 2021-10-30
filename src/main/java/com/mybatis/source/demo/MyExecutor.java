package com.mybatis.source.demo;

import com.mybatis.source.demo.entity.Department;

import java.sql.*;

/**
 * 具体执行语句
 */
public class MyExecutor {

    public <T> T query(String sql, Object param) {
        // 初始化内容
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        T obj = null;

        // 执行jdbc通用流程
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 建立链接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db01", "root", "123456");
            // 3. 创建语句集
            pstm = conn.prepareStatement(String.format(sql, param));
            // 4. 执行语句集
            rs = pstm.executeQuery();
            if (rs.next()) {
                // 5. 一行一行获得结果集
                obj = (T) mapperRow(rs, rs.getRow());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * @param rs resultSet
     * @param i  行索引
     */
    private Department mapperRow(ResultSet rs, int i) throws Exception {
        Department instance = new Department();
        instance.setDept_no(rs.getLong("dept_no"));
        instance.setDept_name(rs.getString("dept_name"));
        instance.setDb_source(rs.getString("db_source"));
        return instance;
    }


}
