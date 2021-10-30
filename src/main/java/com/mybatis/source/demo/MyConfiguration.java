package com.mybatis.source.demo;

import java.util.ResourceBundle;

/**
 * 保存所有配置信息
 */
public class MyConfiguration {

    public static final ResourceBundle sqlMapping;

    static {
        sqlMapping = ResourceBundle.getBundle("sql");
    }

}
