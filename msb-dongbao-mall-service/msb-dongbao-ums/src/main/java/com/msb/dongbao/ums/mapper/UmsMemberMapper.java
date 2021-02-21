package com.msb.dongbao.ums.mapper;

import com.msb.dongbao.ums.entity.UmsMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDto;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author 晁鹏飞
 * @since 2021-02-03
 */
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    UmsMember selectByName(String name);
}
