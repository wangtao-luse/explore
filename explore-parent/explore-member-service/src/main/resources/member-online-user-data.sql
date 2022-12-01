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
values('10000','wwangtaoc11@gamil.com','email','3061312e28decefc38b9bd11fb9e9aff3163bbf7c2fb26e7243eba6c2ec7d93a8db433a47594f21d9d31c9782688dd1b354a3313fb6f19976ae5a9d3c386f001','root','97adc95009094d4ba5c05893527124af');
--初始化角色表
insert into T_m_ROLE(ROLE_CODE,ROLE_NAME,ROLE_NOTE,ROLE_PARENT,CREATE_AT)
values('1','系统管理员','系统管理员使用','-1','1669855946978');
insert into T_m_ROLE(ROLE_CODE,ROLE_NAME,ROLE_NOTE,ROLE_PARENT,CREATE_AT)
values('2','个人','个人使用','-1','1669855946978');
insert into T_m_ROLE(ROLE_CODE,ROLE_NAME,ROLE_NOTE,ROLE_PARENT,CREATE_AT)
values('3','企业','企业使用','-1','1669855946978');