package com.explore.online.lead;

import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.common.leader.OrderDto;
import com.explore.member.api.lead.HystrixLeadApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
@Service
public class HystrixReqMergeService {
	private final static Logger logger=LoggerFactory.getLogger(HystrixReqMergeService.class);
	@Autowired
	HystrixLeadApi hystrixLeadApi;
	/**
	 * 请求合并，远程服务的参数是集合，远程服务的返回值是集合.
	 * HystrixCollapser注解代表当前方法是一个需要做请求合并处理的方法，有Hystrix创建代理实现。
	 * 实现逻辑是：合并请求参数成位一个集合，并处理返回结果集，拆分后，封装成Future对象并返回指定的客户端。
	 * 
	 * @param id
	 * @return 多线程并发结果类型，代表预计结果可能是什么，泛型是具体返回类型
	 */
	@HystrixCollapser(batchMethod = "selectOrderByIds",collapserProperties = {
			//TIMER_DELAY_IN_MILLISECONDS:合并时间窗，最多等待多久，一定请求远程服务。
			//避免无限制等待合并，影响客户端性能。
			@HystrixProperty(name = HystrixPropertiesManager.TIMER_DELAY_IN_MILLISECONDS,value = "200"),
			//MAX_REQUESTS_IN_BATCH:一次合并，最多多少个请求，避免请求参数过多，影响处理效率。
			@HystrixProperty(name = HystrixPropertiesManager.MAX_REQUESTS_IN_BATCH,value="3")
		},
	     //scop:合并请求的范围是什么，默认REQUEST。可选择：GLOBAL-全局范围；REQUEST-一次请求中
	    scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL
			
	)
	public Future<OrderDto> selectOrderById(Long id) {
		return null;
	}
	//合并的批处理远程服务调用逻辑
	@HystrixCommand//代表当前方法由Hystrix管理
	private List<OrderDto> selectOrderByIds(List<Long> ids){
		logger.info("本次请求参数位："+ids);
		List<OrderDto> list = this.hystrixLeadApi.selectOrderByIds(ids);
		logger.info("远程访问结果："+list);
		return list;
		
	}
}
