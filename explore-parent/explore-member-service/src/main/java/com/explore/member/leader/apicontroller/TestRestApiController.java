package com.explore.member.leader.apicontroller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.explore.common.leader.OrderDto;

@RestController
public class TestRestApiController {
@RequestMapping("/rest")
public String rest() {
	String name = Thread.currentThread().getName();
	return "hello, I am "+name+". May I help you?";
}
@RequestMapping("/restWithStr")
public String restWithStr( String arg1) {
	String name = Thread.currentThread().getName();
	return "hello, I am "+name+"."+"params:"+arg1;
}
@RequestMapping("/restWithInt")
public String restWithInt(Integer arg1) {
	String name = Thread.currentThread().getName();
	return "hello, I am "+name+"."+"params:"+arg1;
}
@RequestMapping("/restWithDto")
public OrderDto restWithDto(@RequestBody OrderDto arg1) {
	String name = Thread.currentThread().getName();
	return arg1;
}


}
