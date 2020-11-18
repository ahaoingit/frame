package com.brianyi.mapper;

import com.brianyi.entity.SysRole;
import com.brianyi.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-10-04
 */
public interface UserMapper {
    /***.
     * 通过id查询用户
     *@param id:
     *@author ahao
     *@date 2020-10-04 14:11
     *@return {@link com.brianyi.entity.SysUser}
     *
     */
    SysUser selectById(Long id);

    /**
     *查询所有用户
     * @return
     */
    List<SysUser> selectAll();
    /***.
     *@param id:
     *@author ahao
     *@date 2020-10-04 16:29
     *@return {@link SysRole}
     * 根据id获取 角色
     */
    List<SysRole> selectRolesByUserId(Long id);

    /**
     *添加一个用户
     * @param sysUser
     * @return
     */
    Integer insertUser(SysUser sysUser);

    /**
     * 根据 selectkey 获取非自增主键
     * @param sysUser
     * @return
     */
    Integer getKeyBySelectKey(SysUser sysUser);

    /**
     *  查询用户
     * @param sysUser
     * @return
     */
    SysUser selectByUser(SysUser sysUser);

    /**
     * 根据集合里的id 查询所有用户
     * @param idList
     * @return
     */
    List<SysUser> selectUserByIdList(@Param("ids") List<Long> idList);

    /**
     * 动态更新
     * @param map
     * @return
     */
    Integer updateUser(@Param("setMap") Map<String,Object> map);

    /**
     * 根据id获取用户以及用的角色
     * @param id
     * @return
     */
    SysUser selectUserAndRoleById(Long id);

    SysUser selectRoleMapSelect(Long id);
}
