package com.explore.member.persist;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.explore.model.member.Role;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
public interface RoleMapper extends BaseMapper<Role> {
Set<String> selectMemRoleList(String uid);
}
