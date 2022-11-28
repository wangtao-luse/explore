package com.explore.online.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.explore.online.entity.MyPasswordEncoder;
/**
 * 1.当自定义登录逻辑时容器必须有PasswordEncoder实例;
 * 2.SpringSecurity提供了默认的登录页面，需要自定义的登录页面时，需要修改配置类。
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Bean	
public PasswordEncoder  passwordEncoder () {
	return new MyPasswordEncoder();
	
}
/**
  *  重写父类型中的配置逻辑，如果调用了super.configure(http);则使用父类型的默认流程配置。  
  *  需要自定义，则删除super.configure(http);方法的调用。
 */
@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
	//配置登录请求相关内容
	//1.SpringSecurity提供的处理登录请求过滤器，是path监听软编码的，可以通过此方法动态配置地址。只要配置的地址和页面的请求地址一致，即可完成登录逻辑。
	http.formLogin()	
	    .loginPage("/member/login")//当用户未登录的时候，跳转的登录页面的地址。默认/login
	    .loginProcessingUrl("/member/login")//用户登录逻辑请求地址，默认/login
	    .usernameParameter("loginname")//配置页面用户名参数名,
	    .passwordParameter("nloginpwd");//配置页面密码参数名
	//配置权限校验（如什么地址必须认证后才能访问，什么地址可以不认证就访问）；
	//权限校验配置是线性的，从开始的配置的位置开始校验，成功立刻返回。校验匹配失败，继续后续校验逻辑.(范围小的放到前面)
	http.authorizeRequests()
	    .antMatchers("/member/login","/js/**","/img/**","/css/**").permitAll()//不需要登录即可访问
	    .anyRequest().authenticated();//其他任何请求必须认证后才能访问
	
	//关闭CSRF安全协议（为了保证完整流程的可用）
	http.csrf().disable();

	}
}
