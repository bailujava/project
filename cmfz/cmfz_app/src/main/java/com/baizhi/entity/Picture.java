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
}
