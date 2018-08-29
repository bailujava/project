package com.baizhi.service;

import com.baizhi.dao.PictureDao;
import com.baizhi.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureDao picturecDao;


    @Override
    public List<Picture> queryAll() {
        List<Picture> list = picturecDao.queryAll();

        return list;
    }

    @Override
    public List<Picture> queryY() {
        List<Picture> pictures = picturecDao.queryY();
        return pictures;
    }

    @Override
    public void add(Picture picture) {
        picturecDao.add(picture);
    }

    @Override
    public void delete(Picture picture) {
        picturecDao.delete(picture);
    }

    @Override
    public void update(Picture picture) {
        picturecDao.update(picture);
    }
}
