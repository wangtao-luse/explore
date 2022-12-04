package com.explore.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.member.persist.OauthMapper;
import com.explore.model.member.Oauth;

/**
 * <p>
 * 会员认证表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-11-30
 */
@Service
public class OauthService extends ServiceImpl<OauthMapper, Oauth> {
	
	private final static Logger logger=LoggerFactory.getLogger(OauthService.class);
	//批量添加内部使用
	@Transactional
	public boolean insertOauthBatch(List<Oauth> list) {
		boolean saveBatch = this.saveBatch(list);
		return saveBatch;
	}
}
