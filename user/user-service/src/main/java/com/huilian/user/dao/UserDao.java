package com.huilian.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author renfei
 * @date 2018/11/7
 */
@Mapper
public interface UserDao {

    @Select("select * from weixin_admin")
    List<Map<String,Object>> getUser();

}
