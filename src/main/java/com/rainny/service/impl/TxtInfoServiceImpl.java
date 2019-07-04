package com.rainny.service.impl;

import com.rainny.dao.TxtInfoDao;
import com.rainny.object.TxtInfo;
import com.rainny.service.TxtInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rainny on 2019/6/17.
 */
@Service
public class TxtInfoServiceImpl implements TxtInfoService {

    @Autowired
    private TxtInfoDao txtInfoDao;

    //每次提交50个
    @Override
    public void createInsertList(List<TxtInfo> txtInfoList) {
        //每次提交的个数
        int count = 50;
        int lastIndex = count;
        for (int index = 0; index < txtInfoList.size();) {
            if (lastIndex > txtInfoList.size()) {
                lastIndex=txtInfoList.size();
                txtInfoDao.insertList(txtInfoList.subList(index,lastIndex));
                break;
            }else {
                txtInfoDao.insertList(txtInfoList.subList(index,lastIndex));
                index=lastIndex;
                lastIndex=index+count-1;
            }
        }


    }

    @Override
    public void createBatchList(List<TxtInfo> txtInfoList) throws SQLException {
       txtInfoDao.addBatch(txtInfoList);
    }
}
