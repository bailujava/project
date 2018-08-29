package com.baizhi.dao;

import com.baizhi.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MenuDao {

    public List<Menu> queryAll();

    public void add(Menu menu);

    public void update(Menu menu);

    public void delete(Menu menu);
}
