package com.rainny.dao;

import com.rainny.object.SysUser;

import java.util.List;

public interface SysUserDao {
    /**
     * 通过username查找用户信息;
     */
   SysUser findUserByUserName(String username);

    /**
     * 根据用户id查找用户权限标识信息
     * 例如：sys:role:view,sys:role:add
     * @param username
     * @return
     */
    List<String> findUserPermissions(String username);
}
