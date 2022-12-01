--1.会员信息表
CREATE TABLE IF NOT EXISTS T_M_MEMBER(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
UID	VARCHAR(10) UNIQUE COMMENT'用户唯一号',
CREATE_AT  BIGINT COMMENT'注册时间',
CREATE_IP VARCHAR(15)COMMENT'注册IP地址',
LAST_TIME	BIGINT COMMENT'上次登录时间',
STATUS VARCHAR(2) COMMENT'状态(0：禁用；1:正常(审核通过);2:锁定状态)',
CATEGORY VARCHAR(2) COMMENT'用户类别(1:个人用户;2:企业用户)'
)COMMENT'会员信息表';
--2.用户认证表
CREATE TABLE IF NOT EXISTS T_M_OAUTH(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
UID	VARCHAR(10) COMMENT'用户唯一号',
OAUTH_ID VARCHAR(200) UNIQUE COMMENT'第三方登录唯一ID	(站内保存手机号码,用户名，邮箱)',
OAUTH_TYPE VARCHAR(18) COMMENT'第三方登录平台标识(手机：phone;邮箱：email;QQ:qq;微信：wechat;用户名：uid;微博:weibo)',
CREDENTIAL VARCHAR(500)COMMENT'密码凭证(站内的保存密码，站外的不保存或保存token)',
NICKNAME	VARCHAR(18) COMMENT'昵称',
AVATAR	VARCHAR(120) COMMENT'图像',
PASSWD  VARCHAR(36) COMMENT'盐值'
)COMMENT'会员认证表';

--3.登录记录表
CREATE TABLE IF NOT EXISTS T_M_LOGIN_LIST(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号标识	主键,自动增长',
UID	VARCHAR(10) COMMENT'用户唯一号',
OAUTH_ID	VARCHAR(200) COMMENT'登录账号',
OAUTH_TYPE  VARCHAR(18) COMMENT'登录账号类型',
CATEGORY VARCHAR(2) COMMENT'用户类别(1:个人用户;2:企业用户)',
LOGIN_At	BIGINT COMMENT'登录时间',	
LOGIN_IP	VARCHAR(15) COMMENT'登录IP',		
addr	VARCHAR(18) COMMENT'IP位置'	
)COMMENT'登录记录表';

--4.会员组表
CREATE TABLE IF NOT EXISTS T_M_GROUP( 
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT'组编号',
Group_NAME	VARCHAR(30) COMMENT'组名称',
Group_PARENT	INT COMMENT'所属组编号(-1:超级组)',
GROUP_NOTE	VARCHAR(50)COMMENT'组描述'	,
CREATE_AT BIGINT COMMENT'创建日期'
)COMMENT'会员组表';
--5.会员-会员组表
CREATE TABLE IF NOT EXISTS T_M_MEMBER_GROUP(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
UID	VARCHAR(10)	COMMENT'用户唯一号',
GROUP_ID	INT COMMENT'组编号'
) COMMENT'会员-会员组表(中间表)';
--6.角色表
CREATE TABLE IF NOT EXISTS T_m_ROLE(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'	编号',
ROLE_NAME	VARCHAR(30) COMMENT'角色名称',
ROLE_NOTE	VARCHAR(50) COMMENT '角色描述',
ROLE_PARENT INT COMMENT'所属角色编号(-1:超级角色)',
CREATE_AT   BIGINT COMMENT '创建日期'
) COMMENT'角色表';

--7.会员组-角色表
CREATE TABLE IF NOT EXISTS T_M_GROUP_ROLE(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
ROLE_ID	INT	COMMENT '角色编号',
GROUP_ID	INT	COMMENT '组编号'
);

--8.权限主表
CREATE TABLE IF NOT EXISTS T_A_RIGHT(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
RIGHT_NO VARCHAR(10) COMMENT '权限唯一标识',
RIGHT_NAME VARCHAR(120) COMMENT '权限名称',
Right_type VARCHAR(2) COMMENT'资源类型(0:菜单;1:按钮;2:其他)',
RIGHT_NOTE VARCHAR(80) COMMENT'描述'
)COMMENT'权限主表';

--9.角色-权限表
CREATE TABLE IF NOT EXISTS T_M_ROLE_RIGHT(
ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
ROLE_ID INT COMMENT '角色编号',
RIGHT_ID INT COMMENT '权限编号'
)COMMENT '角色权限表';

--10.权限明细表
CREATE TABLE IF NOT EXISTS T_M_RIGHT_DETAIL(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
RIGHT_NO varchar(10) COMMENT '权限唯一标识',
URL VARCHAR(120) COMMENT '资源',
ISLOGIN	VARCHAR(5)COMMENT'是否登录(anon 不需要登录 authc 需要登录)',
ISLOG	VARCHAR(2) COMMENT'是否记日志(0:不需要;1:需要)'
)COMMENT'权限主表';

--11.菜单-权限表
CREATE TABLE IF NOT EXISTS T_M_MENU(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
MODULE_NO VARCHAR(10) COMMENT '模块编号',
MODULE_NAME VARCHAR(18)COMMENT '模块名称',
RIGHT_NO VARCHAR(10) COMMENT '权限标识',
MENU_ID VARCHAR(10) COMMENT '菜单编号',
MENU_NAME VARCHAR(120) COMMENT '菜单名称',
PARENT_ID INT COMMENT '父菜单ID(-1:表示顶级菜单)',
ORDER_NUM VARCHAR(4) COMMENT '显示顺序',
url VARCHAR(200) COMMENT'菜单地址',
menu_type VARCHAR(2)COMMENT'菜单类型(1:菜单;2:按钮)',
visible varchar(2)COMMENT '菜单状态（0显示 1隐藏）',
icon varchar(200)COMMENT '菜单图标',
target varchar(20)COMMENT '打开方式(新窗口|内页)',
create_by varchar(18) COMMENT '菜单创建者',
update_by varchar(18) COMMENT '菜单更新者',
create_at BIGINT COMMENT '菜单创建时间',
remark varchar(300) COMMENT '备注'
)COMMENT'权限主表';

--12.个人信息
CREATE TABLE IF NOT EXISTS T_M_PERSON(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
gender VARCHAR(2)COMMENT'性别 (0:女;1:男)',
STATUS VARCHAR(2) COMMENT'1:待审核;2:审核通过;3:审核不通过',
REMARK VARCHAR(300) COMMENT'审核不通过备注'
)COMMENT'个人信息表';
--13 企业信息
CREATE TABLE IF NOT EXISTS T_M_BUSINESS(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
BUSINESSNAME varchar(200) COMMENT '企业名称',
TAXPAYERID varchar(18) COMMENT '统一社会信用代码',
PROVINCE   varchar(18) COMMENT '企业省份',
CITY       varchar(18) COMMENT '企业城市',
AREA       varchar(18)COMMENT '企业所属区',
ENTERPRISE_ADDR varchar(120) COMMENT '企业地址',
EMERGENCY_CONTACT varchar(18)COMMENT '联系人姓名',
INDUSTRY varchar(18) COMMENT'所属行业',
CERT_IMAGE_URL varchar(200) COMMENT'工商营业执照',
STATUS VARCHAR(2) COMMENT'1:待审核;2:审核通过;3:审核不通过',
REMARK VARCHAR(300) COMMENT'审核不通过备注'
)COMMENT'企业信息表';


--1.会员信息表
CREATE TABLE IF NOT EXISTS T_M_SYS_MEMBER(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
UID	VARCHAR(10) COMMENT'用户唯一号',
CREATE_AT  BIGINT COMMENT'注册时间',
CREATE_IP VARCHAR(15)COMMENT'注册IP地址',
LAST_TIME	BIGINT COMMENT'上次登录时间',
STATUS VARCHAR(2) COMMENT'状态(0：禁用；1：待审核;2:审核不通过;3:正常(审核通过);4:锁定状态)',
CATEGORY VARCHAR(2) COMMENT'用户类别(1:个人用户;2:企业用户)'
)COMMENT'会员信息表';
--2.用户认证表
CREATE TABLE IF NOT EXISTS T_M_SYS_OAUTH(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
UID	VARCHAR(10) COMMENT'用户唯一号',
OAUTH_ID VARCHAR(200) UNIQUE COMMENT'第三方登录唯一ID	(站内保存手机号码,用户名，邮箱)',
OAUTH_TYPE VARCHAR(18) COMMENT'第三方登录平台标识(手机：phone;邮箱：email;QQ:qq;微信：wechat;用户名：uid;微博:weibo)',
CREDENTIAL VARCHAR(500)COMMENT'密码凭证(站内的保存密码，站外的不保存或保存token)',
NICKNAME	VARCHAR(18) COMMENT'昵称',
AVATAR	VARCHAR(120) COMMENT'图像',
PASSWD  VARCHAR(36) COMMENT'盐值'
)COMMENT'会员认证表';

--3.登录记录表
CREATE TABLE IF NOT EXISTS T_M_SYS_LOGIN_LIST(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号标识	主键,自动增长',
UID	VARCHAR(10) COMMENT'用户唯一号',
OAUTH_ID	VARCHAR(200) COMMENT'登录账号',
OAUTH_TYPE  VARCHAR(18) COMMENT'登录账号类型',
CATEGORY VARCHAR(2) COMMENT'用户类别(1:个人用户;2:企业用户)',
LOGIN_At	BIGINT COMMENT'登录时间',	
LOGIN_IP	VARCHAR(15) COMMENT'登录IP',		
addr	VARCHAR(18) COMMENT'IP位置'	
)COMMENT'登录记录表';

--4.会员组表
CREATE TABLE IF NOT EXISTS T_M_SYS_GROUP( 
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT'组编号',
Group_NAME	VARCHAR(30) COMMENT'组名称',
Group_PARENT	INT COMMENT'所属组编号(-1:超级组)',
GROUP_NOTE	VARCHAR(50)COMMENT'组描述'	,
CREATE_AT BIGINT COMMENT'创建日期'
)COMMENT'会员组表';
--5.会员-会员组表
CREATE TABLE IF NOT EXISTS T_M_SYS_MEMBER_GROUP(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'编号',
UID	VARCHAR(10)	COMMENT'用户唯一号',
GROUP_ID	INT COMMENT'组编号'
) COMMENT'会员-会员组表(中间表)';
--6.角色表
CREATE TABLE IF NOT EXISTS T_M_SYS_ROLE(
ID	INT PRIMARY KEY AUTO_INCREMENT COMMENT'	编号',
ROLE_NAME	VARCHAR(30) COMMENT'角色名称',		
ROLE_NOTE	VARCHAR(50) COMMENT '角色描述',
ROLE_PARENT INT COMMENT'所属角色编号(-1:超级角色)',
CREATE_AT   BIGINT COMMENT '创建日期'
) COMMENT'角色表';

--7.会员组-角色表
CREATE TABLE IF NOT EXISTS T_M_SYS_GROUP_ROLE(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
ROLE_ID	INT	COMMENT '角色编号',
GROUP_ID	INT	COMMENT '组编号'
);

--8.权限主表
CREATE TABLE IF NOT EXISTS T_A_SYS_RIGHT(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
RIGHT_NO VARCHAR(10) COMMENT '权限唯一标识',
RIGHT_NAME VARCHAR(120) COMMENT '权限名称',
Right_type VARCHAR(2) COMMENT'资源类型(0:菜单;1:按钮;2:其他)',
RIGHT_NOTE VARCHAR(80) COMMENT'描述'
)COMMENT'权限主表';

--9.角色-权限表
CREATE TABLE IF NOT EXISTS T_M_SYS_ROLE_RIGHT(
ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
ROLE_ID INT COMMENT '角色编号',
RIGHT_ID INT COMMENT '权限编号'
)COMMENT '角色权限表';

--10.权限明细表
CREATE TABLE IF NOT EXISTS T_M_SYS_RIGHT_DETAIL(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
RIGHT_NO varchar(10) COMMENT '权限唯一标识',
URL VARCHAR(120) COMMENT '资源',
ISLOGIN	VARCHAR(5)COMMENT'是否登录(anon 不需要登录 authc 需要登录)',
ISLOG	VARCHAR(2) COMMENT'是否记日志(0:不需要;1:需要)'
)COMMENT'权限主表';

--11.菜单-权限表
CREATE TABLE IF NOT EXISTS T_M_SYS_MENU(
ID	INT	PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
MODULE_NO VARCHAR(10) COMMENT '模块编号',
MODULE_NAME VARCHAR(18)COMMENT '模块名称',
RIGHT_NO VARCHAR(10) COMMENT '权限标识',
MENU_ID VARCHAR(10) COMMENT '菜单编号',
MENU_NAME VARCHAR(120) COMMENT '菜单名称',
PARENT_ID INT COMMENT '父菜单ID(-1:表示顶级菜单)',
ORDER_NUM VARCHAR(4) COMMENT '显示顺序',
url VARCHAR(200) COMMENT'菜单地址',
menu_type VARCHAR(2)COMMENT'菜单类型(1:菜单;2:按钮)',
visible varchar(2)COMMENT '菜单状态（0显示 1隐藏）',
icon varchar(200)COMMENT '菜单图标',
target varchar(20)COMMENT '打开方式(新窗口|内页)',
create_by varchar(18) COMMENT '菜单创建者',
update_by varchar(18) COMMENT '菜单更新者',
create_at BIGINT COMMENT '菜单创建时间',
remark varchar(300) COMMENT '备注'
)COMMENT'权限主表';



