package com.mybatis.source.demo.entity;

import com.mybatis.source.demo.MyConfiguration;
import com.mybatis.source.demo.MyExecutor;

/**
 * 对外提供方法
 */
public class MySqlSession {

    private MyConfiguration config;
    private MyExecutor executor;

    public MySqlSession() {
        this.config = new MyConfiguration();
        this.executor = new MyExecutor();
    }

    public <T> T findById(String statementId, Long dept_no) {
        String sql = MyConfiguration.sqlMapping.getString(statementId);
        System.out.println(sql);
        return executor.query(sql, dept_no);
    }

}
