package com.rainny.daoImpl;

import com.rainny.dao.TxtInfoDao;
import com.rainny.object.TxtInfo;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
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

        return this.sqlSessionTemplate;
    }

    @Override
    public void insertList(List<TxtInfo> txtInfoList) {

        this.getSqlSessionTemplate().insert("insertList", txtInfoList);
    }
    @Override
    public void addBatch(List<TxtInfo> txtInfoList) throws SQLException {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        sqlSession.getConnection().setAutoCommit(false);
        TxtInfoDaoImpl txtInfoDao = sqlSession.getMapper(TxtInfoDaoImpl.class);
        int size = 500;
        int lastindex = size;
        try {
            for (int index = 0; index < txtInfoList.size();) {
                if (lastindex > txtInfoList.size()) {
                    lastindex = txtInfoList.size();
                    sqlSession.insert("insertList", txtInfoList.subList(index, lastindex));
                    sqlSession.commit();
                    break;
                } else {
                    sqlSession.insert("insertList", txtInfoList.subList(index, lastindex));
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
*/
}
