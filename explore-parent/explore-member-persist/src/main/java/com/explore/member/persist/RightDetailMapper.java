package com.explore.member.persist;

import java.util.List;

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
	
	List<RightDetail> selectRightDetailList(String uid);

}
