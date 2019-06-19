package com.rainny.daoImpl;

import com.rainny.dao.TxtInfoDao;
import com.rainny.object.TxtInfo;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019/6/17.
 */
@Repository
public class TxtInfoDaoImpl implements TxtInfoDao {

    private static final Logger logger = Logger.getLogger(TxtInfoDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        logger.info(this.sqlSessionTemplate);
        return this.sqlSessionTemplate;
    }

    @Override
    public void insertList(List<TxtInfo> txtInfoList) {
        this.getSqlSessionTemplate().insert("insertList", txtInfoList);
    }

    /*@Override
    public List<TxtInfo> getList(TxtInfo txtInfo) {
        return this.getSqlSessionTemplate().selectList("getList", txtInfo);
    }

    @Override
    public void deleteOne(String txtname) {
        this.getSqlSessionTemplate().delete("delete", txtname);
    }

    @Override
    public void getOne(TxtInfo txtInfo) {
        this.getSqlSessionTemplate().selectOne("getOne", txtInfo);
    }
*/}
