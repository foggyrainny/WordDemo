package com.rainny.service.impl;

import com.rainny.dao.DataDao;
import com.rainny.object.Data;
import com.rainny.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;
    @Override
    public void createInserList(List<Data> dataList) throws SQLException {

        dataDao.insertList(dataList);
    }
}
