package com.rainny.daoImpl;

import com.rainny.dao.SysUserDao;
import com.rainny.object.SysUser;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysUserDaoImpl implements SysUserDao {

    private static final Logger logger = Logger.getLogger(SysUserDaoImpl.class);

    private static final String PRE = "com.rainny.mapper.SysUserMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {

        return this.sqlSessionTemplate;
    }

    @Override
    public SysUser findUserByUserName(String username) {

        return this.getSqlSessionTemplate().selectOne(PRE+"findUserByUserName",username);
    }

    @Override
    public List<String> findUserPermissions(String username) {
        return this.getSqlSessionTemplate().selectList(PRE+"findUserPermissions",username);
    }
}
