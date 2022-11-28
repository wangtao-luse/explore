package com.explore.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.explore.common.leader.SysUserDto;
import com.explore.member.api.MemberApi;
/**
 * 
 * 1.SpringSecurity提供了UserDetailsService接口来完成用户认证;
 * 2.用户查询只能用用户名作为条件，查询用户
 * 3.密码匹配是由SpringSecurity内部逻辑自动完成的，只需要包查询的用户名正确返回即可。
 *            返回结果时通过UserDetails类型的实现类，可以自定义或使用Security框架提供的实现类。
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	MemberApi memberApi;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//1.根据用户名查询，用户名不存在抛异常
		SysUserDto user = new SysUserDto();
		SysUserDto selectOne = user.selectOne();	
		if(null == selectOne) {
			throw new UsernameNotFoundException("该用户不存在");
		}
		String password = selectOne.getPasswd();
		List authorities = AuthorityUtils.createAuthorityList();//使用AuthorityUtils工具类可以通过字符串，创建权限集合
		//2.用户名存在，匹配用户名和密码是否正确。匹配密码是有spring security内部逻辑自动完成的，只需要将查询到的用户名正确密码返回即可。
		//  返回结果的是UserDetails的实现类，可以自定义，也可以使用Security提供的实现类。 
	   //   username:用户身份(用户名)；password:用户正确密码(数据库中的密码)；authorities：权限集合  
		User  result = new User(username, password , authorities);
		return result;
	}

}
