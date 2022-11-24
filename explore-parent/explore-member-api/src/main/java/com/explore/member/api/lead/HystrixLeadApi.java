package com.explore.member.api.lead;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.explore.common.leader.OrderDto;




@FeignClient(name = "explore-member-service",contextId = "member-hystrix")
public interface HystrixLeadApi {
@RequestMapping("test/hystrixShow")
	String hystrixShow();
@RequestMapping("test/hystrixTime")
String hystrixTime();
@RequestMapping("test/hystrixFusing")
String hystrixFusing();
@RequestMapping("test/reqCache")
String reqCache(@RequestParam Long id);
@RequestMapping("test/selectOrderByIds")
List<OrderDto> selectOrderByIds(@RequestParam List<Long> ids);
}
