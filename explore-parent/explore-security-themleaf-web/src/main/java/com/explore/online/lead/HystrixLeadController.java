package com.explore.online.lead;


import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.explore.common.leader.OrderDto;
import com.explore.member.api.lead.HystrixLeadApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
/**
 * 
 * 1.雪崩效应
 *         在微服务架构项目中，尤其是中大型项目，肯定会出现一个服务调用其他服务，其他服务又调用别的服务，服务与服务之间形成了一中链式调用关系。
 *        如果一个服务出现了问题，调用这个服务就会出现线程阻塞的情况，此时若有大量的请求涌入，就会出现多条线程阻塞等待，进而导致服务瘫痪。
 *       由于服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果。
 *       
 * 2.如何防止灾难性雪崩效应
 * 1.降级
 *         降级是指，当请求超时、资源不足等情况发生时进行服务降级处理，不调用真实服务逻辑，而是使用快速失败(fallback）方式直接返回一个托底数据，保证服务链条的完整，避免服务雪崩。
 * 2.熔断
 *          降级是指，当请求超时、资源不足等情况发生时进行服务降级处理，不调用真实服务逻辑，而是使用快速失败(fallback）方式直接返回一个托底数据，保证服务链条的完整，避免服务雪崩。
 * 3.请求缓存
 * 
 * 4.请求合并
 *           请求合并是将一段时间范围内的所有请求合并为一个请求，大大降低了Application Service负载。
 * 5.隔离
 *    1.线程池隔离：当使用线程池隔离的时候，不同接口有自己独立的线程池。即是某一个线程池被占用，也不影响其他线程。
 *    2.信号量隔离：


 *    
 *
 */

@Controller
@RequestMapping("test")
public class HystrixLeadController {
	private final static Logger logger=LoggerFactory.getLogger(HystrixLeadController.class);
	@Autowired
	HystrixLeadApi testHystrixtApi;
	@Autowired
	HystrixReqMergeService  hystrixReqMergeService;
	@ResponseBody
	@RequestMapping("/show")
	public String show() {
		return this.testHystrixtApi.hystrixShow();
	}
/**
 *1.远程服务访问错误：远程服务不可用或.远程服务响应超时。远程服务访问正常：有返回结果或有异常传递；
 *2.默认情况下SpringCloud远程访问，不管远程访问多长时间，SpringCloud都会等待。想要连接超时可以在启动类上使用@EnableHystrix注解，开启Hystrix容错处理能力。Hystrix默认设置一个远程访问超时时间配置，默认为1秒。
 *3.在服务方法上添加@HystrixCommand注解。代表该方法是一个需要做容错处理的方法。默认设置远程超时1秒。fallbackMethod属性代表如果远程调用发生错误(远程服务不可以或超时)，则调用对应的方法并返回。
 *3.服务降级步骤:
 * 	1.在application client导入Hystrix依赖
 *  2.在application client请求方法上添加@HystrixCommand
 *  3.在对应的启动类上增加新的注解@EnableHystrix
 *  4.编写服务降级方法
 *
 *4.特点：降级每次远程请求都会调用服务方法；
 * @return
 */
@ResponseBody	
@RequestMapping("/hystrixDegradation")
@HystrixCommand(fallbackMethod = "hystrixDegradationBack")
public String 	hystrixDegradation() {
   logger.info("本地降级方法执行-----------------------");
	String openFeign = testHystrixtApi.hystrixTime();
	return openFeign;
}
/**
 * 降级方法要求:
 * 1.返回值和对应的服务方法返回类型必须一致；
 * 2.方法的参数列表和对应服务方法一致；
 * @return
 */
public  String hystrixDegradationBack() {
	return "服务繁忙，请稍后再试！";
}

/**
 *   服务熔断
 *1.熔断：当一定时间内，异常请求比例（请求超时、网络故障、服务异常等） 达到阀信时，启动熔断器，熔断器一旦启动，则会停止调用具体服务逻辑，   通过 faillback 快速返回托底数据，保证服务链的完整。
 *2.使用Hystrix实现服务降级、熔断步骤
 *  1.在application client导入Hystrix依赖
 *  2.在application client请求方法上添加@HystrixCommand
 *  3.在对应的启动类上增加新的注解@EnableHystrix
 * fallbackMethod：服务降级执行的方法
 * hystrix 
 * @return
 */

@ResponseBody
@RequestMapping("/hystrixFusing")
//如果10秒内，失败率达到请求次数(2)的50%，也就是1次就会就会开启熔断。
@HystrixCommand(fallbackMethod = "reqTimeout",commandProperties = {
	//@HystrixProperty提供了一个服务容错处理配置，name为要配置的属性，value是具体配置数据， name属性可以参考工具类HystrixPropertiesManager中的常量或直接使用字符串;
	//CIRCUIT_BREAKER_ENABLED：是否开启熔断策略。默认值为 true。
	@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value ="true"),
    //CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD:在单位时间内(10秒),发送远程访问错误的次数阈值，达到开启熔断。默认值为 20次请求
	@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value="2"),
	//CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE:在单位时间内(10秒),发送远程访问错误的百分比，达到阈值开启熔断。默认50%
	@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value="50"),
	//CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS:开启熔断后，多少毫秒内不发起远程访问.默认5秒
	@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value="5000"),
	//CIRCUIT_BREAKER_FORCE_OPEN:是否强制开启熔断，如果强制开启，永远不远程访问，默认false;
	@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_FORCE_OPEN,value="false"),
	//CIRCUIT_BREAKER_FORCE_CLOSED:是否强制关闭熔断，如果强制关闭，前置配置无效.即一定调用远程服务。默认为false
	@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_FORCE_CLOSED,value="false"),
	//远程调处理的用单位时间设置，默认10秒，单位毫秒；
	@HystrixProperty(name=HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value="10000"),
})
public String hystrixFusing() {
	logger.info("本地熔断方法执行。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
	String openFeign = testHystrixtApi.hystrixFusing();
	//String openFeign = testHystrixtApi.hystrixTime();
	return openFeign;
}
/**
 * 熔断方法要求:
 * 1.返回值和对应的服务方法返回类型必须一致；
 * 2.方法的参数列表和对应服务方法一致；
 * @return
 */
public String reqTimeout() {
	return Thread.currentThread().getName()+"服务不可用--开启熔断";
}

/**
 * 请求缓存
 * 如果相同的请求，且缓存中有数据，当前方法不执行，直接返回缓存结果
 *如果需要加Hystrix容错逻辑，直接编写相关注解即可。如果增加了Hystrix容错逻辑，必须给请求缓存逻辑，增加例外，避免缓存拖地数据。
 *需要在配置类上使用@EnableCaching开启缓存，需要redis支持
 * @param id
 * @return
 */
@ResponseBody
@RequestMapping("/reqCache")
@Cacheable(cacheNames = "hystrix:cache",key = "'reqCache('+#id+')'")
@HystrixCommand(fallbackMethod = "reqCacheBack")
public String reqCache(Long id) {
	logger.info("本地方法执行。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
	String reqCache = this.testHystrixtApi.reqCache(id);
	return reqCache;
}
public String reqCacheBack(Long id) {
	return Thread.currentThread().getName()+"缓存方法-降级";
}

@ResponseBody
@RequestMapping("/selectOne")
public OrderDto selectOne(Long id) {
	OrderDto orderDto = null;
	try {
		//问题将处理的方法放一个类合并失败
		 orderDto = hystrixReqMergeService.selectOrderById(id).get();
		
		 
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return orderDto;	
}

/**
 * 请求合并，远程服务的参数是集合，远程服务的返回值是集合.
 * HystrixCollapser注解代表当前方法是一个需要做请求合并处理的方法，有Hystrix创建代理实现。
 * 实现逻辑是：合并请求参数成位一个集合，并处理返回结果集，拆分后，封装成Future对象并返回指定的客户端。
 * 
 * @param id
 * @return 多线程并发结果类型，代表预计结果可能是什么，泛型是具体返回类型
 */
//@HystrixCollapser(batchMethod = "selectOrderByIds",collapserProperties = {
		//TIMER_DELAY_IN_MILLISECONDS:合并时间窗，做多等待多久，一定请求远程服务。
		//避免无限制等待合并，影响客户端性能。
	//	@HystrixProperty(name = HystrixPropertiesManager.TIMER_DELAY_IN_MILLISECONDS,value = "200"),
		//MAX_REQUESTS_IN_BATCH:一次合并，最多多少个请求，避免请求参数过多，影响处理效率。
	//	@HystrixProperty(name = HystrixPropertiesManager.MAX_REQUESTS_IN_BATCH,value="3")
	//},
     //scop:合并请求的范围是什么，默认REQUEST。可选择：GLOBAL-全局范围；REQUEST-一次请求中
   // scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL
		
//)
public Future<OrderDto> selectOrderById(Long id) {
	return null;
}
//合并的批处理远程服务调用逻辑
//@HystrixCommand//代表当前方法由Hystrix管理
private List<OrderDto> selectOrderByIds(List<Long> ids){
	logger.info("本次请求参数位："+ids);
	List<OrderDto> list = this.testHystrixtApi.selectOrderByIds(ids);
	logger.info("远程访问结果："+list);
	return list;
	
}

/**
 * 线程池隔离
 * groupKey:分组命名，默认和Threadpool的key相同
 * commandKey:命令,一般等于方法
 * threadPoolKey:独立线程池命名前缀
 * threadPoolProperties:线程池配置信息
 * @return
 */
@ResponseBody
@RequestMapping("/isolateThreadPool")
@HystrixCommand(fallbackMethod = "isolateThreadPoolBack",groupKey = "test", commandKey = "isolateThreadPool",
     threadPoolKey = "hystrix-test-pool",threadPoolProperties = {
    	//CORE_SIZE：线程池容量
    	@HystrixProperty(name = HystrixPropertiesManager.CORE_SIZE,value ="4"),
    	//MAX_QUEUE_SIZE:线程池中的线程消耗完毕后，提供的阻塞队列容量
    	@HystrixProperty(name = HystrixPropertiesManager.MAX_QUEUE_SIZE,value ="10"),
     })
public  String isolateThreadPool() {
	String hystrixShow = this.testHystrixtApi.hystrixShow();
	return Thread.currentThread().getName();
}
public  String isolateThreadPoolBack() {
	return "线程池隔离";
}
//信号量隔离
@ResponseBody
@RequestMapping("/isolateMount")
@HystrixCommand(fallbackMethod = "isolateMountBack",groupKey = "test", commandKey = "isolateThreadPool",
     threadPoolKey = "hystrix-test-pool",threadPoolProperties = {
    	//EXECUTION_ISOLATION_STRATEGY：线程隔离机制，默认是THREAD线程池隔离，可选SEMAPHORE信号量隔离
    	@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY,value ="SEMAPHORE"),
    	//EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS:设置信号量阈值
    	@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS,value ="10"),
     })
public  String isolateMount() {
	String hystrixShow = this.testHystrixtApi.hystrixShow();
	return Thread.currentThread().getName();
}
public  String isolateMountBack() {
	return Thread.currentThread().getName();
}

}
