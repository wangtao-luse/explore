package com.explore.member.apicontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.explore.common.leader.OrderDto;
import com.explore.member.api.lead.HystrixLeadApi;
@RestController
public class LeadHystrixApiConroller implements HystrixLeadApi{
	private final static Logger logger=LoggerFactory.getLogger(LeadHystrixApiConroller.class);
	@Override
	public String hystrixShow() {
		// TODO Auto-generated method stub
		logger.info("I'm hystrixShow");
		return "I'm hystrixShow ."+Thread.currentThread().getName();
	}
	@Override
	public String hystrixTime() {
		// TODO Auto-generated method stub	
		logger.info("hello! hystrix");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hello! hystrix";
	}
	@Override
	public String hystrixFusing() {
		// TODO Auto-generated method stub
		logger.info("hystrixFusing, What's your favorite fruit？");
		return Thread.currentThread().getName()+"hystrixFusing ";
	}
	@Override
	public String reqCache(Long id) {
		// TODO Auto-generated method stub
		logger.info("reqCache, id------》"+id);
		return "id="+id+"name="+"name"+id;
	}
	@Override
	public List<OrderDto> selectOrderByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		List<OrderDto> list = new ArrayList<OrderDto>();
		for (Long id : ids) {
			OrderDto o = new OrderDto();
			o.setId(id);
			o.setName(UUID.randomUUID().toString());
			list.add(o);
		}
		
		return list;
	}
	
	






	
	

}
