package com.explore.member.persist;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.explore.model.member.RightDetail;

/**
 * <p>
 * 权限主表 Mapper 接口
 * </p>
 *
 * @author wwangtaoc11@gamil.com
 * @since 2022-12-01
 */
public interface RightDetailMapper extends BaseMapper<RightDetail> {
	
	Set<String> selectMemRightDetailList(String uid);
	List<String> selectAnonUrl();

}
