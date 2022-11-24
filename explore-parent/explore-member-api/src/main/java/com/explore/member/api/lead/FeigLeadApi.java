package com.explore.member.api.lead;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

/**
 * 当接口上配了 FeignClient 和 RequestMapping 两个注解，结果错误提示 重复mapping处理方法,
 * 解决方案：去除接口上的@RequestMapping,将@RequestMapping放到方法的声明上;
 * @author wwang
 *
 */
@FeignClient(name = "explore-member-service",contextId = "member-feign")
public interface FeigLeadApi {
@RequestMapping("test/feign")
String openFeign();
@RequestMapping("test/feignWithStr")
String feignWithStr(@RequestParam String feignWithStr);
@RequestMapping("test/feignWithInteger")
String feignWithInteger(@RequestParam Integer feignWithStr);
@RequestMapping("test/feignWithMap")
String feignWithMap(@RequestParam Map<String, Object> map);
@RequestMapping("test/feignWithJson")
String feignWithJson(@RequestBody JSON json);


}
