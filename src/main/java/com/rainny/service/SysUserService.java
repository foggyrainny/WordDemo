package com.rainny.service;

import com.rainny.object.SysPermission;
import com.rainny.object.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser findUserByUserName(String userName);

    List<SysPermission> findUserPermissions(String userName);
}
