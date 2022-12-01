CREATE OR  REPLACE VIEW t_m_member_Oauth_view as
select c.*,d.OAUTH_ID,d.OAUTH_TYPE,d.CREDENTIAL,d.NICKNAME,d.AVATAR,d.PASSWD from t_m_member c,t_m_oauth d where c.UID = d.UID;

