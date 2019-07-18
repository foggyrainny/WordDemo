package com.rainny.object;

import java.util.List;
/**
 * create by rainy
 * shiro 实例
 * */

public class SysPermission {

    private Integer id;

    private String name;

    private String resourceType;//资源类型

    private String url;//资源路径

    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private Long parentid;

    private String parentids;

    private Boolean avaivable = Boolean.FALSE;

    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getParentids() {
        return parentids;
    }

    public void setParentids(String parentids) {
        this.parentids = parentids;
    }

    public Boolean getAvaivable() {
        return avaivable;
    }

    public void setAvaivable(Boolean avaivable) {
        this.avaivable = avaivable;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
