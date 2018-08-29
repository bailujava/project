package com.baizhi.dao;

import com.baizhi.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PictureDao {
    public List<Picture> queryAll();

    public void add(Picture picture);

    public void delete(Picture picture);

    public void update(Picture picture);

    public List<Picture> queryY();
}
