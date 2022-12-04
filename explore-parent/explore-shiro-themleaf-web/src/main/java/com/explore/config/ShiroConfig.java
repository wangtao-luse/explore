package com.explore.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.explore.common.encryption.CryptoUtil;
import com.explore.common.resp.ResponseMessage;
import com.explore.common.tool.StringTool;
import com.explore.online.connector.MemberConnector;
import com.explore.online.realm.MyRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {
	 @Autowired 
	  MemberConnector memberConnector;
//1.Realm 代表系统资源	
@Bean
public MyRealm  myReaml(HashedCredentialsMatcher credentialsMatcher) {
	MyRealm myRealm = new MyRealm();
	myRealm.setCredentialsMatcher(credentialsMatcher);
	return myRealm;
}

//2.SecurityManager 流程控制
@Bean
public DefaultWebSecurityManager securityManager(MyRealm myRealm) {
	//创建SecurityManager对象
	DefaultWebSecurityManager security = new DefaultWebSecurityManager();
	//将Realm存入到SecurityManager中
	security.setRealm(myRealm);	
	return security;
}

//3. 请求过滤
@Bean
public ShiroFilterFactoryBean  shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
	ShiroFilterFactoryBean  shiroFilter = new ShiroFilterFactoryBean ();
	shiroFilter.setSecurityManager(securityManager);
	shiroFilter.setUnauthorizedUrl("/membeer/deny");// 未授权界面(没有权限);
	//设置登录页面,如果不设置会默认去找项目根目录下的login.jsp
	shiroFilter.setLoginUrl("/member/login");
	//配置路径过滤key：是ant路径,支持*,**,?;value配置shiro的默认过滤器, anon:匿名访问;authc:需要认证(登录)才能访问; 
	//实际开发中会从数据库中读取对应的权限
	Map<String,String> filterMap = new LinkedHashMap<String, String>();
	filterMap.put("/css/**","anon");
	filterMap.put("/md/**","anon");
	filterMap.put("/js/**","anon");
	filterMap.put("/img/**","anon");
	filterMap.put("/test/**", "anon");
	// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
	filterMap.put("/shiro/logout", "logout");
	ResponseMessage resp = memberConnector.selectAnonUrl(null, null);
	if(ResponseMessage.successed(resp) && !StringTool.isEmpty(resp.getResultData())) {
		List<String> permission = (List<String>)resp.getResultData();
		for (String ssion : permission) {
			filterMap.put(ssion, "anon");
		}
	}

	//不能访问的情况下shiro会自动跳转到setLoginUrl()的页面;
	filterMap.put("/**", "authc");
	shiroFilter.setFilterChainDefinitionMap(filterMap);
	
	
	return shiroFilter;
}
//告诉Shiro使用什么方式加密
@Bean
public HashedCredentialsMatcher credentialsMatcher() {
	HashedCredentialsMatcher  matcher= new HashedCredentialsMatcher();
	matcher.setHashAlgorithmName(CryptoUtil.SIMPLEHASH_SHA512);//加密方式
	matcher.setHashIterations(CryptoUtil.HASHITERATIONS_DEFAULT);//迭代加密次数
	return matcher;
}
@Bean //为了整合themleaf,配置用于解析thymeleaf中的shiro:相关属性
public ShiroDialect shiroDialect() {
	return new ShiroDialect();
}

}
