package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdminDao {
    public Admin queryOne(@Param("username") String username, @Param("password") String password);

    public void add(Admin admin);
}
