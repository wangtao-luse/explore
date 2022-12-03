package com.explore.online.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
/*import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.explore.common.constant.ConstantMem;
import com.explore.common.constant.ConstantSys;
import com.explore.common.resp.ResponseMessage;

@Controller
@RequestMapping("/member")
public class MemberController {
	  private final static Logger logger=LoggerFactory.getLogger(MemberController.class);
	  @GetMapping("/login")
	  public String login() {
		return "/passport/login";
	  }

	  @PostMapping("/login")	  
	  @ResponseBody 
	  public ResponseMessage login(@RequestBody JSONObject jsonObject,HttpServletRequest request) { 
		  ResponseMessage responseMessage = ResponseMessage.success(); 
		  try { 
			  String username =	  jsonObject.getString("username"); 
			  String password =   jsonObject.getString("passwd"); 
			  //1.初始化获取securityManager并获取Subject对象
			  Subject currentUser = SecurityUtils.getSubject();
			  //2.创建token对象，web应用用户名和密码从页面传递
			  UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray()); 
			  //3.完成登录
			  currentUser.login(token); 
			  } catch (UnknownAccountException e) { 
				  // TODO:handle exception 
				  logger.error(e.getMessage()); 
				  return ResponseMessage.fail(e.getMessage());
			  } catch (IncorrectCredentialsException e) { 
				   // TODO: handle exception
			      logger.error(e.getMessage());
			      return ResponseMessage.fail(ConstantMem.MEM_INCORRECTCREDENTIALS);
			  } catch (LockedAccountException e) { 
				  // TODO: handle exception
				  logger.error(e.getMessage()); 
				  return ResponseMessage.fail(e.getMessage());
			  } catch (ExcessiveAttemptsException e) { 
				  // TODO: handle exception
			      logger.error(e.getMessage()); 
			      return ResponseMessage.fail(ConstantMem.MEM_EXCESSIVEATTEMPTS);
			  }catch (AuthenticationException e) { 
				  // TODO:handle exception 
				  logger.error(e.getMessage());
				  return ResponseMessage.fail(ConstantMem.MEM_INCORRECTCREDENTIALS);
			  }catch (Exception e) { 
				  // TODO: handle exception 
				  logger.error(e.getMessage()); 
				  return ResponseMessage.fail(ConstantSys.SYS_ERROR);
			  } 
		     return  responseMessage; 
	  }
	  /**
	   * 没有权限访问页面
	   * @return
	   */
	 @GetMapping("/deny")
	public String deny() {
		return "/member/deny";
	}
	 /**
	  * 404页面
	  * @return
	  */
	 @GetMapping("/lost")
	public String lost() {
			return "/error/lost";
		}
}
