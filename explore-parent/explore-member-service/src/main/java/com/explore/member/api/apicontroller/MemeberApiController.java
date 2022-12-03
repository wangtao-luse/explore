package com.explore.member.api.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.explore.common.req.RequestMessage;
import com.explore.common.resp.ResponseMessage;
import com.explore.member.api.MemberApi;
import com.explore.member.service.MemberOauthViewService;
import com.explore.member.service.MemberService;
import com.explore.member.service.RightDetailService;
import com.explore.member.service.RoleService;

@RestController
public class MemeberApiController implements MemberApi{

	
	@Autowired
	RightDetailService rightDetailService;
	@Autowired
	RoleService roleService;
	@Autowired
	MemberOauthViewService memberOauthViewService;
	@Autowired
	MemberService memberService;
	@Override
	public ResponseMessage selectMemberOauthOne(RequestMessage requestMsg) {
		// TODO Auto-generated method stub
		return memberOauthViewService.selectMemberOauthOne(requestMsg);
	}

	@Override
	public ResponseMessage selectMemRoleList(RequestMessage requestMsg) {
		// TODO Auto-generated method stub
		return roleService.selectMemRoleList(requestMsg);
	}

	@Override
	public ResponseMessage selectMemRightDetailList(RequestMessage requestMsg) {
		// TODO Auto-generated method stub
		return rightDetailService.selectMemRightDetailList(requestMsg);
	}

	@Override
	public ResponseMessage selectAnonUrl(RequestMessage requestMsg) {
		// TODO Auto-generated method stub
		return rightDetailService.selectAnonUrl(requestMsg);
	}

	@Override
	public ResponseMessage updateMemberById(RequestMessage requestMsg) {
		// TODO Auto-generated method stub
		return memberService.updateMemberById(requestMsg);
	}

}
