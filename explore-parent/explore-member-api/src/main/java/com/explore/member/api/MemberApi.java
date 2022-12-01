package com.explore.member.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;

@FeignClient(name = "explore-member-service",contextId = "member")
public interface MemberApi {
@RequestMapping("/member/selectMemberOauthOne")
ResponseMessage selectMemberOauthOne(@RequestBody RequestMessage requstMsg);
@RequestMapping("/member/selectMemRoleList")
ResponseMessage selectMemRoleList(@RequestBody RequestMessage requstMsg);
@RequestMapping("/member/selectRightDtailList")
ResponseMessage selectRightDtailList(@RequestBody RequestMessage requstMsg);
}
