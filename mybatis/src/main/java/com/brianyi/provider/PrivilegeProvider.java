package com.brianyi.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * TODO
 *
 * @author ahao 2020-10-07
 */
public class PrivilegeProvider {
    public String selectById(Long id) {
        return new SQL() {
            {
                SELECT("id,privilege_name,privilege_url");
                FROM("sys_privilege");
                WHERE("id=#{id}");
            }
        }.toString();
    }

}
