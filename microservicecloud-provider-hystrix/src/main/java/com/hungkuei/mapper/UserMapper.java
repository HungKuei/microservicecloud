package com.hungkuei.mapper;

import com.hungkuei.model.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_user where user_id = #{userId}")
    TUser selectByUserId(Integer userId);

    @Select("select * from t_user")
    List<TUser> selectAll();
}
