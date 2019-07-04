package com.rainny.service;

import com.rainny.object.TxtInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/6/17.
 */
public interface TxtInfoService {

    void  createInsertList(List<TxtInfo>  txtInfoList );

    void  createBatchList(List<TxtInfo>  txtInfoList) throws SQLException;

}
