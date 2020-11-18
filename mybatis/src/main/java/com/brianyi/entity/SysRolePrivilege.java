package com.brianyi.entity;

import java.io.Serializable;

/**
 * 角色权限关联表(SysRolePrivilege)实体类
 *
 * @author makejava
 * @since 2020-10-04 09:37:28
 */
public class SysRolePrivilege implements Serializable {
    private static final long serialVersionUID = -65434280034359292L;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long privilegeId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

}