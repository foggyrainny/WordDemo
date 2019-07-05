package com.rainny.dao;

import com.rainny.object.Data;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4.
 */
public interface DataDao {
    //批量插入数据
    void  insertList(List<Data> dataList) throws SQLException;

}
