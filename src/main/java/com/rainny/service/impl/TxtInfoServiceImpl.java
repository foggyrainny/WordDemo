package com.rainny.service.impl;

import com.rainny.dao.TxtInfoDao;
import com.rainny.object.TxtInfo;
import com.rainny.service.TxtInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rainny on 2019/6/17.
 */
@Service
public class TxtInfoServiceImpl implements TxtInfoService {

    @Autowired
    private TxtInfoDao txtInfoDao;

    @Override
    public void createInsertList(List<TxtInfo> txtInfoList) {
        if(txtInfoList.size()<=50){
            txtInfoDao.insertList(txtInfoList);
        }else {
            List<TxtInfo> txtInfoList2 =new ArrayList();

        }


    }
}
