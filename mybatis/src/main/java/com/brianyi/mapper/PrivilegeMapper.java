package com.brianyi.mapper;

import com.brianyi.entity.SysPrivilege;
import com.brianyi.provider.PrivilegeProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * TODO
 *
 * @author ahao 2020-10-04
 */
public interface PrivilegeMapper {
    @SelectProvider(type = PrivilegeProvider.class,method = "selectById")
    SysPrivilege selectById(Long id);
}
