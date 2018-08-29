package com.baizhi.action;

import com.baizhi.entity.Picture;
import com.baizhi.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    PictureService pictureService;

    @ResponseBody
    @RequestMapping("/all")
    public List<Picture> all() {
        List<Picture> pictures = pictureService.queryAll();
        return pictures;
    }

    @ResponseBody
    @RequestMapping("/Y")
    public List<Picture> queryY() {
        List<Picture> pictures = pictureService.queryY();
        return pictures;
    }

    @RequestMapping("/")
    public String add(Picture picture) {
        pictureService.add(picture);
        return "";
    }

    @RequestMapping("/")
    public String delete(Picture picture) {
        pictureService.delete(picture);
        return "";
    }

    @RequestMapping("/")
    public String update(Picture picture) {
        pictureService.update(picture);
        return "";
    }
}
