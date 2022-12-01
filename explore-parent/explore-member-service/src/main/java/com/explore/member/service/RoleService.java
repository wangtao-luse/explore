package com.explore.member.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.member.persist.RoleMapper;
import com.explore.model.member.Role;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

}
