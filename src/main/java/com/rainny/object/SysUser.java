package com.rainny.object;
/**
* create by rainy
* shiro 实例
* */

import java.util.List;

public class SysUser {

    private Integer uid;
    //账户名
    private String username;

    private String password;
    //盐
    private String salt;
    //用户状态
    private byte state;

    private List<SysRole> roleList;// 一个用户具有多个角色

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
