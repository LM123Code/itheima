//package com.itheima13.dao.impl;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
///**
// * @author LM_Code
// * @create 2019-02-28-20:26
// */
//public class JdbcDaoSupport {
//    private JdbcTemplate jdbcTemplate;
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//    public void setDataSource(DataSource dataSource){
//        //判断jdbcTemplate是否为null
//        if(jdbcTemplate == null)
//            createJdbcTemplate(dataSource);
//    }
//
//    private void createJdbcTemplate(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//}
