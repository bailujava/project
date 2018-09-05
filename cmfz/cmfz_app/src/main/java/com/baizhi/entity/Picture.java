package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Picture implements Serializable {
    private Integer id;
    private String title;
    private String imgPath;
    private String description;
    private String status;
    private Date createDate;

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Picture(Integer id, String title, String imgPath, String description, String status, Date createDate) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
    }

    public Picture() {
    }
}
