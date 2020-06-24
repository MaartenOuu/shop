package com.ou.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ou.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Owq
 * @since 2020-06-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
