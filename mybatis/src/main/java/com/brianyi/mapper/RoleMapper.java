package com.brianyi.mapper;

import com.brianyi.entity.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * TODO
 *
 * @author ahao 2020-10-04
 */
public interface RoleMapper {
    /**
     * 根据id查询角色
     * @param id
     * @return
     */
//    @Results(id = "roleResultMap",value = {
//            @Result(property = "id",column = "id" ,id = true),
//            @Result(property = "roleName",column = "role_name"),
//            @Result(property = "enabled",column = "enabled"),
//            @Result(property = "createBy",column = "create_by"),
//            @Result(property = "createTime",column = "create_time")
//    })
//    @Select("select id,role_name,enabled,create_by,create_time from sys_role where id = #{id}")
    SysRole selectRoleById(Long id);

    /**
     * 查询所有角色
     * @return
     * 此处 resultMap 是引用上面的结果映射 也可以引用xml中的
     *
     */
//    @ResultMap("roleResultMap")
//    @Select("select id,role_name,enabled,create_by,create_time from sys_role")
    List<SysRole> selectAllRole();


    /**
     * 添加角色 返回自增主键
     * @param sysRole
     * @return
     */
    @Insert("insert into sys_role(role_name,enabled,create_by,create_time) values (#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertRole(SysRole sysRole);

    /**
     * 获取非自增主键
     * @param sysRole
     * @return
     */
    @Insert("insert into sys_role(role_name,enabled,create_by,create_time) values (#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",resultType = Long.class,before = false)
    int insertRoleGetNotAutoKey(SysRole sysRole);

}
