package com.explore.member.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.member.persist.GroupMapper;
import com.explore.model.member.Group;

/**
 * <p>
 * 会员组表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class GroupService extends ServiceImpl<GroupMapper, Group> {

}
