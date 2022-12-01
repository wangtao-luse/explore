package com.explore.online.realm;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.explore.common.leader.SysUser;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.tool.StringTool;
import com.explore.common.util.HttpDataUtil;
import com.explore.member.api.MemberApi;
import com.explore.model.member.RightDetail;
import com.explore.model.member.Role;
import com.explore.model.member.vo.MemberOauthView;
public class MyRealm extends AuthorizingRealm {
	
	  @Autowired 
	  MemberApi memberApi;
	 
	//认证方法，shiro的login方法底层会调用该类的认证方法进行认证
	//需要配置的自定义的Realm生效，需要配置ini文件中配置或在Springboot中配置
	//该方法只是获取进行对比的信息。认证的逻辑还是按照shiro底层认证逻辑完成。
	@Override	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		// TODO Auto-generated method stub
		// 1.获取身份信息
		String principal = token.getPrincipal().toString();
		// 2.获取凭证信息
		String credentials = new String((char[]) token.getCredentials());
		// 3.获取数据库中存储的用户信息
		JSONObject jsonObjct = new JSONObject();
		jsonObjct.put("OAUTH_ID", principal);
		RequestMessage postData = HttpDataUtil.postData(jsonObjct, null);
		 ResponseMessage resp = memberApi.selectMemberOauthOne(postData); // 判断用户式否存在，存在将数据封装返回，否则抛出异常；
		if (ResponseMessage.successed(resp) && StringTool.isEmpty(resp.getResultData())) {
			throw new UnknownAccountException();
		}
		MemberOauthView sysUser = (MemberOauthView)resp.getResultData();
		String hashedCredentials = sysUser.getCredential();
		String realmName = getName();
		ByteSource credentialsSalt = ByteSource.Util.bytes(principal); // 4.创建封装校验逻辑对象，封装数据返回
		// principal:认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对(从数据库中获取)
		// hashedCredentials:加密后的密码(从数据库中获取) //credentialsSalt:盐
		// realmName:Realm对象的name，调用父类的getName()方法即可 // 
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,hashedCredentials,credentialsSalt,realmName);

		return info;
	}
	 
	@Override	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// TODO Auto-generated method stub
		// 1.从PrincipalCollection获取登录用户的信息
		// 获取登录用户的信息
		SysUser principal = (SysUser) principals.getPrimaryPrincipal();
		// 2.利用登录的用户信息来获取当前用户的角色或权限(可能需要查询数据库)
		JSONObject jsonObjct = new JSONObject();
		jsonObjct.put("OAUTH_ID", principal);
		RequestMessage postData = HttpDataUtil.postData(jsonObjct, null);
	    ResponseMessage respMsg = memberApi.selectMemRoleList(postData);		
		ResponseMessage response = memberApi.selectRightDtailList(postData); 
		// 3.创建SimpleAuthorizationInfo并设置roles属性和StringPermissions属性
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	    if (ResponseMessage.successed(respMsg) && !StringTool.isEmpty(respMsg.getResultData())) {
			Set<String> roles =(Set<String>)respMsg.getResultData();
			info.setRoles(roles);
			
		}
	    if (ResponseMessage.successed(response) && !StringTool.isEmpty(response.getResultData())) {
			List<RightDetail> rList =(List<RightDetail>)respMsg.getResultData();
			Set<String> stringPermissions = rList.stream().map(RightDetail::getUrl).collect(Collectors.toSet());
			info.setStringPermissions(stringPermissions);
			
		}
		return info;
	}
	 

}