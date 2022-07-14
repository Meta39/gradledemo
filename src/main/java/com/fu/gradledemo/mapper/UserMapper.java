package com.fu.gradledemo.mapper;

import com.fu.gradledemo.entity.User;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据ID查询
     */
    User select(@Param("id") Long id);

    /**
     * 查询全部
     */
    List<User> selectAll();

    /**
     * 新增
     */
    int insert(User user);

    /**
     * 更新
     */
    int update(User user);

    /**
     * 删除
     */
    int delete(@Param("id") Long id);

}
