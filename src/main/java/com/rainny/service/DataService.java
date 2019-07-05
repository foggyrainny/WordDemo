package com.rainny.service;

import com.rainny.object.Data;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4.
 */
public interface DataService {

    void  createInserList(List<Data> dataList) throws SQLException;
}
