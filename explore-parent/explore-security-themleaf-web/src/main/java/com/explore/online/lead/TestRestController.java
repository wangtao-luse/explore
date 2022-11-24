package com.explore.online.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.explore.common.leader.OrderDto;
import com.explore.common.tool.StringTool;
/**
 * 1.将RestTemplate注册到Spring容器中
 * 2.使用
 *   常用方法：
 *  getForObject()返回值是HTTP协议的响应体。
 *  getForEntity()返回的是ResponseEntity，ResponseEntity是对HTTP响应的封装，除了包含响应体，还包含HTTP状态码、contentType、contentLength、Header等信息。
 *  
 */
@Controller
@RequestMapping("test")
public class TestRestController {
	@Autowired
	RestTemplate restTemplate;
	/**
	 * 无参方法
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/rest")
	public String rest() {
		String url ="http://explore-member-service/rest";
		String forObject = restTemplate.getForObject(url, String.class);
		return forObject;
	}
	/**
	 * 字符串参数
	 * @param str
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/restWithStr")
	public String restWithStr(String str) {
		String url ="http://explore-member-service/restWithStr?arg1= {0}";
		String forObject = restTemplate.getForObject(url, String.class,StringTool.isEmpty(str)?"restWithStr":str);
		return forObject;
	}
	/**
	 * Integer参数
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/restWithInt")
	public String restWithInt(Integer num) {
		String url ="http://explore-member-service/restWithInt?arg1= {0}";
		String forObject = restTemplate.getForObject(url, String.class,StringTool.isEmpty(num)? 1:num);
		return forObject;
	}
	/**
	 * 对象参数
	 * @param num
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping("/restWithDto")
	public String restWithDto() {
		OrderDto order = new OrderDto(1L, "test") ;
		String url ="http://explore-member-service/restWithDto";
		String forObject = restTemplate.postForObject(url, order, String.class);
		return forObject;
	}
}
