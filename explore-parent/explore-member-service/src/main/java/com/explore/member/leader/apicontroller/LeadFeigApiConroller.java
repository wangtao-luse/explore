package com.explore.member.leader.apicontroller;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.explore.member.api.lead.FeigLeadApi;

@RestController
public class LeadFeigApiConroller implements FeigLeadApi{

	@Override
	public String openFeign() {	
		return "I'm openFeign style.";
	}

	@Override
	public String feignWithStr(String feignWithStr) {
		// TODO Auto-generated method stub
		return "I'm "+Thread.currentThread().getName()+". Hi,"+feignWithStr;
	}

	@Override
	public String feignWithInteger(Integer feignWithStr) {
		// TODO Auto-generated method stub
		 return "I'm "+Thread.currentThread().getName()+". Hi,"+feignWithStr;
	}

	@Override
	public String feignWithMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return "I'm a map."+map;
	}

	@Override
	public String feignWithJson(JSON json) {
		// TODO Auto-generated method stub
		return "I'm a JSON"+json;
	}

}
