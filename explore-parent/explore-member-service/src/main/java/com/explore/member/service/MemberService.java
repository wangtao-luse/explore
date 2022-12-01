package com.explore.member.service;

import com.explore.model.member.Member;
import com.explore.common.exception.BaseException;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.member.persist.MemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员信息表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-11-30
 */
@Service
public class MemberService extends ServiceImpl<MemberMapper, Member>  {
	private final static Logger logger=LoggerFactory.getLogger(OauthService.class);
}
