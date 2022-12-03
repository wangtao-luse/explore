--初始化用户组
insert into T_M_GROUP(GROUD_CODE,Group_NAME,Group_PARENT,GROUP_NOTE,CREATE_AT)
values('1','系统用户','-1','系统管理者使用','1669857258752');
insert into T_M_GROUP(GROUD_CODE,Group_NAME,Group_PARENT,GROUP_NOTE,CREATE_AT)
values('2','个人用户','-1','个人用户使用','1669857258752');
insert into T_M_GROUP(GROUD_CODE,Group_NAME,Group_PARENT,GROUP_NOTE,CREATE_AT)
values('3','企业用户','-1','企业用户使用','1669857258752');
--初始化管理员账号
insert into T_M_MEMBER(UID,CREATE_AT,CREATE_IP,STATUS,CATEGORY)
values('10000','1669857279649','127.0.0.1','1','1');
insert into T_M_OAUTH(UID,OAUTH_ID,OAUTH_TYPE,CREDENTIAL,NICKNAME,PASSWD)
values('10000','wwangtaoc11@gamil.com','email','cb065ca77b76d451db32881a900117ea8017445e892ee040affdf339523fdfd330047b4fb1123df4e18323b1676a46d9950410ee5f9a44386c06cf6c22102f75','root','b326c2b2ac80413b88903f5c8438337e');
--初始化角色表
insert into T_m_ROLE(ROLE_CODE,ROLE_NAME,ROLE_NOTE,ROLE_PARENT,CREATE_AT)
values('1','系统管理员','系统管理员使用','-1','1669855946978');
insert into T_m_ROLE(ROLE_CODE,ROLE_NAME,ROLE_NOTE,ROLE_PARENT,CREATE_AT)
values('2','个人','个人使用','-1','1669855946978');
insert into T_m_ROLE(ROLE_CODE,ROLE_NAME,ROLE_NOTE,ROLE_PARENT,CREATE_AT)
values('3','企业','企业使用','-1','1669855946978');

--权限明细(会员online)
insert into T_M_RIGHT_DETAIL(RIGHT_CODE,URL,ISLOGIN,ISLOG)
values('-2','/member/login','anon','0');
insert into T_M_RIGHT_DETAIL(RIGHT_CODE,URL,ISLOGIN,ISLOG)
values('-2','/member/deny','anon','0');