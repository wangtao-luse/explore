package com.explore.member.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.member.persist.BusinessMapper;
import com.explore.model.member.Business;

/**
 * <p>
 * 企业信息表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-03
 */
@Service
public class BusinessService extends ServiceImpl<BusinessMapper, Business> {
	/**
	 * 内部使用
	 * @param jsonObject
	 * @return
	 */
public int insertBusiness(JSONObject jsonObject) {
	Business po = jsonObject.toJavaObject(Business.class);
	int insert = this.baseMapper.insert(po);
	return insert;
}
}
