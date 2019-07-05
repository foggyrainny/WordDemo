package com.rainny.daoImpl;

import com.rainny.dao.DataDao;
import com.rainny.object.Data;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4.
 */
@Repository
public class DataDaoImpl implements DataDao{

    private static final Logger logger = Logger.getLogger(DataDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {

        return this.sqlSessionTemplate;
    }

    @Override
    public void insertList(List<Data> dataList) throws SQLException{
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        sqlSession.getConnection().setAutoCommit(false);
        DataDaoImpl dataDao = sqlSession.getMapper(DataDaoImpl.class);
        int size = 800;
        int lastindex = size;
        try {
            for (int index = 0; index < dataList.size();) {
                if (lastindex > dataList.size()) {
                    lastindex = dataList.size();
                    sqlSession.insert("insertList", dataList.subList(index, lastindex));
                    sqlSession.commit();
                    break;
                } else {
                    sqlSession.insert("insertList", dataList.subList(index, lastindex));
                    sqlSession.commit();
                    index = lastindex;
                    lastindex = index + size ;
                }


            }
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error(e);
        } finally {
            sqlSession.close();
        }
    }
}
