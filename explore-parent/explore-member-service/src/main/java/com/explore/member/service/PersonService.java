package com.explore.member.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.explore.member.persist.PersonMapper;
import com.explore.model.member.Person;

/**
 * <p>
 * 个人信息表 服务实现类
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-03
 */
@Service
public class PersonService extends ServiceImpl<PersonMapper, Person> {
/**
 * 内部使用
 * @param jsonObject
 * @return
 */
public int insertPerson(JSONObject jsonObject) {
	Person p = jsonObject.toJavaObject(Person.class);
	int insert = this.baseMapper.insert(p);
	return insert;
}
}
