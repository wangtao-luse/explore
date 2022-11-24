package com.explore.online.lead;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.explore.member.api.lead.FeigLeadApi;

/**
 * OpenFegin是一种声明式、模板化的客户端。声明式调用是指，就像调用本地方法一样调用远程方法，无需感知操作远程RPC请求。
 * 使用：
 * 1.添加spring-cloud-starter-openfeign
 * 2.在接口上编写@FeignClient
 * 3.调用方启动类上添加@EnableFeignClients
 * @author wwang
 *
 */
@Controller
@RequestMapping("test")
public class FeginLeadController {
	@Autowired
	FeigLeadApi feigLeadApi;
@ResponseBody
@RequestMapping("/hello")
public String hello() {
	String name = Thread.currentThread().getName();
	return "hello, I am "+name+"May I help you?";
}

/**
 * openfeign 无参数调用
 * @return
 */
@ResponseBody
@RequestMapping("/feign")
public String testFeign() {
	
	String openFeign = feigLeadApi.openFeign();
	return openFeign;
}
/**
 * openfeign 传递字符串
 * @return
 */
@ResponseBody
@RequestMapping("/feignWithStr")
public String feignWithStr(String name) {
	
	String openFeign = feigLeadApi.feignWithStr(name);
	return openFeign;
}
/**
 * openfeign 传递字Integer类型参数
 * @return
 */
@ResponseBody
@RequestMapping("/feignWithInteger")
public String feignWithInteger(Integer num) {
	
	String openFeign = feigLeadApi.feignWithInteger(num);
	return openFeign;
}
/**
 * openfeign 传递字Map类型参数
 * @return
 */
@ResponseBody
@RequestMapping("/feignWithMap")
public String feignWithMap() {
	HashMap<String, Object> map =new HashMap<String, Object>();
	map.put("name", "wangtao");
	map.put("id", "10000");
	String openFeign = feigLeadApi.feignWithMap(map);
	return openFeign;
}

/**
 * openfeign 传递字Map类型参数
 * @return
 */
@ResponseBody
@RequestMapping("/feignWithJson")
public String feignWithJson() {
	HashMap<String, Object> map =new HashMap<String, Object>();
	map.put("name", "wangtao");
	map.put("id", "10000");
	String jsonString = JSONObject.toJSONString(map);
	JSONObject parseObject = JSON.parseObject(jsonString);
	String openFeign = feigLeadApi.feignWithJson(parseObject);
	return openFeign;
}


}
