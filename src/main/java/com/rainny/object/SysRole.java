package com.rainny.object;

import java.util.List;
/**
 * create by rainy
 * shiro 实例
 * */

public class SysRole  {

    private Integer id;//编号

    private String role;//角色

    private String description;//用于界面描述

    private Boolean available = Boolean.FALSE;// 是否可用,如果不可用将不会添加给用户

    private List<SysPermission> permissions;

    private List<SysUser> userList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }
}
