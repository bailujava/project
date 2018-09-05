package com.baizhi.action;

import com.baizhi.entity.Picture;
import com.baizhi.service.PictureService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("/add")
    public String add(Picture picture, MultipartFile img, HttpServletRequest request) {
        //指定文件上传位置
        String realPath = request.getRealPath("/");
        String s = realPath + "upload";
        File files = new File(s);
        //防止文件重名
        String originalFilename = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        //获得扩展名
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName=uuid+"."+extension;
        //上传文件到指定文件夹
        try {
            img.transferTo(new File(files, s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        picture.setImgPath("/load/"+newName);
        pictureService.add(picture);
        return "";
    }

    @RequestMapping("/delete")
    public String delete(Picture picture) {
        pictureService.delete(picture);
        return "";
    }

    @RequestMapping("/update")
    public String update(Picture picture) {
        pictureService.update(picture);
        return "";
    }
}
