package com.explore.online.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
@RequestMapping("/index")
public String index() {
	return "/index";
}
@RequestMapping("/test/hello")
@ResponseBody
public String test() {
	return "hello";
}	
}
