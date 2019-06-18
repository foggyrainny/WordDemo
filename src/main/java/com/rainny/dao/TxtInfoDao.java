package com.rainny.dao;

import com.rainny.object.TxtInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/6/17.
 */

public interface TxtInfoDao {

     //批量插入数据
     void  insertList(List<TxtInfo> txtInfoList);
     //根据日期和销货方名称查询数据
     List<TxtInfo> getList(TxtInfo txtInfo);
     //根据文档名称删除数据
     void deleteOne(String txtname);

     void getOne(TxtInfo txtInfo);



}
