package com.baizhi.service;

import com.baizhi.entity.Picture;

import java.util.List;

public interface PictureService {
    public List<Picture> queryAll();

    public List<Picture> queryY();

    public void add(Picture picture);

    public void delete(Picture picture);

    public void update(Picture picture);


}
