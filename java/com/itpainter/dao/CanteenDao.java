package com.itpainter.dao;


import com.itpainter.domain.Windows;
import com.itpainter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CanteenDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //查询指定楼层的窗口
    public List<Windows> findAll(String canteen, String tier){

        List<Windows> res = new ArrayList<>();
        String sql = "select window_id,window_name,window_canteen,window_tier,window_num,window_picture from windows where window_canteen = ? and window_tier = ?";
        List<String> params = new ArrayList<>();
        params.add(canteen);params.add(tier);
        try {
            res = template.query(sql,new BeanPropertyRowMapper<Windows>(Windows.class),params.toArray());
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return res;
    }

    //查询指定时间段指定楼层剩余位置
    public Integer findEmpty(String canteen,String tier,String time) {
        String sql = "select upperlimit-nownum from time where canteen = ? and tier = ? and style = ?";
        Integer res =null;
        try{
            res = template.queryForObject(sql,Integer.class,canteen,tier,time);
        }catch (Exception e){

        }
        return res;
    }
}
