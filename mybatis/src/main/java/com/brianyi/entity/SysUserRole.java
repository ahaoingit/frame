package com.brianyi.entity;

import java.io.Serializable;

/**
 * 用户角色关联表(SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-10-04 09:40:33
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 700785432472053085L;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}