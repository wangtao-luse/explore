package com.explore.online.controller;

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
