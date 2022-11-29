package com.explore.member.api;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.explore.common.leader.SysUser;
import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;

@FeignClient(name = "explore-member-service",contextId = "member")
public interface MemberApi {
@RequestMapping("/member/login")
ResponseMessage login(@RequestBody RequestMessage requstMsg);
@RequestMapping("/member/selectOne")
SysUser selectOne(String username);
@RequestMapping("/member/selectRoleList")
Set<String> selectRoleList(String username);
@RequestMapping("/member/selectRightList")
Set<String> selectRightList(String username);
}
