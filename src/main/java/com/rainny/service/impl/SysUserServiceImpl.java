package com.rainny.service.impl;

import com.rainny.object.SysPermission;
import com.rainny.object.SysUser;
import com.rainny.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private  SysUserService sysUserService;

    @Override
    public SysUser findUserByUserName(String userName) {
        return sysUserService.findUserByUserName(userName);
    }

    @Override
    public List<SysPermission> findUserPermissions(String userName) {
        return sysUserService.findUserPermissions(userName);
    }
}
