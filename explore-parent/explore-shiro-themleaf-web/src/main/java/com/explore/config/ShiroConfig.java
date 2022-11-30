package com.explore.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.explore.online.realm.MyRealm;

@Configuration
public class ShiroConfig {
/**
 * 1.Realm 代表系统资源	
 * 
 */
@Bean
public MyRealm  myReaml(HashedCredentialsMatcher credentialsMatcher) {
	MyRealm myRealm = new MyRealm();
	myRealm.setCredentialsMatcher(credentialsMatcher);
	return myRealm;
}
/**
 * 2.SecurityManager 流程控制
 * @param myRealm
 * @return
 */
@Bean
public DefaultWebSecurityManager securityManager(MyRealm myRealm) {
	//创建SecurityManager对象
	DefaultWebSecurityManager security = new DefaultWebSecurityManager();
	//将Realm存入到SecurityManager中
	security.setRealm(myRealm);
	
	return security;
}
/**
 *3. 请求过滤
 * @param securityManager
 * @return
 */
@Bean
public ShiroFilterChainDefinition shiroFilterFactoryBean () {
	 DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
	return definition;
}
/**
 * 告诉Shiro使用什么方式加密
 * @return
 */
@Bean
public HashedCredentialsMatcher credentialsMatcher() {
	HashedCredentialsMatcher  matcher= new HashedCredentialsMatcher();
	matcher.setHashAlgorithmName("MD5");//加密方式
	matcher.setHashIterations(8192);//迭代加密次数
	return matcher;
	
	
}

}