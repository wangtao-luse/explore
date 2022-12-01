package com.explore.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.common.tool.StringTool;
import com.explore.member.persist.MemberOauthViewMapper;
import com.explore.model.member.vo.MemberOauthView;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
@Service
public class MemberOauthViewService extends ServiceImpl<MemberOauthViewMapper, MemberOauthView> {
	private final static Logger logger=LoggerFactory.getLogger(MemberOauthViewService.class);
public MemberOauthView selectOne(MemberOauthView memberVo) {
	QueryWrapper<MemberOauthView> queryWrapper = new QueryWrapper<MemberOauthView>();
	queryWrapper.eq(!StringTool.isEmpty(memberVo.getOauthId()), "OAUTH_ID", memberVo.getOauthId());
	MemberOauthView selectOne = this.baseMapper.selectOne(queryWrapper );
	return selectOne;
	
}
}
